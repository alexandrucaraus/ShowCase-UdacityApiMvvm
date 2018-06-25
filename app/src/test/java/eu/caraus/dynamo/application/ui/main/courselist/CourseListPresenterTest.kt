package eu.caraus.dynamo.application.ui.main.courselist

import com.nhaarman.mockitokotlin2.*
import eu.caraus.dynamo.application.common.schedulers.TestSchedulerProvider
import eu.caraus.dynamo.application.domain.udacity.CoursesItem
import io.reactivex.subjects.PublishSubject

import org.hamcrest.core.IsNot.not
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat


class CourseListPresenterTest {


    @Mock
    lateinit var view: CourseListContract.View

    @Mock
    lateinit var navigator: CourseListContract.Navigator

    private val testScheduler = TestSchedulerProvider()

    private lateinit var presenter : CourseListPresenterImpl

    @Before
    fun setUp() {

        MockitoAnnotations.initMocks(this)

    }

    private fun courseListSuccess_data() : List<CoursesItem> {

        val item1 = CoursesItem()
        item1.key = "testItem1"

        val item2 = CoursesItem()
        item2.key = "testItem2"

        return listOf( item1, item2 )
    }

    private val courseListSuccessData = courseListSuccess_data()

    @Test
    fun getCourseListSuccess_test() {

        val interactor = object : CourseListContract.Interactor {
            val rxDataReady = PublishSubject.create<List<CoursesItem>>()
            val rxDataError = PublishSubject.create<String>()
            override fun getData() {
                rxDataReady.onNext( courseListSuccessData )
            }
            override fun getFreshData() {}
            override fun rxDataReady() : PublishSubject<List<CoursesItem>> { return rxDataReady }
            override fun rxDataError(): PublishSubject<String> { return rxDataError }
        }


        presenter = CourseListPresenterImpl( interactor, navigator, testScheduler )

        presenter.onCreate()

        presenter.onViewAttached( view )

        presenter.onResume()

        verify( view, timeout(100).times(1)).showProgress()
        verify( view, timeout(100).times(1)).hideProgress()
        verify( view, timeout(2000).times(1)).addItems( courseListSuccessData )

    }

    private val courseListErrorData = "Failed to get data"

    @Test
    fun getCourseListError_test() {

        val interactor = object : CourseListContract.Interactor {
            val rxDataReady = PublishSubject.create<List<CoursesItem>>()
            val rxDataError = PublishSubject.create<String>()
            override fun getData() {
                rxDataError.onNext( courseListErrorData )
            }
            override fun getFreshData() {}
            override fun rxDataReady() : PublishSubject<List<CoursesItem>> { return rxDataReady }
            override fun rxDataError(): PublishSubject<String> { return rxDataError }
        }

        presenter = CourseListPresenterImpl( interactor, navigator, testScheduler )

        presenter.onCreate()

        presenter.onViewAttached( view )

        presenter.onResume()

        verify( view, timeout(100).times(1)).showProgress()
        verify( view, timeout(100).times(1)).hideProgress()
        verify( view, timeout(100).times(1)).showServiceCallError( courseListErrorData )

    }

    private fun setupCourseDatailsNavigation_test(){
        val interactor = object : CourseListContract.Interactor {
            val rxDataReady = PublishSubject.create<List<CoursesItem>>()
            val rxDataError = PublishSubject.create<String>()
            override fun getData() {
                rxDataReady.onNext( courseListSuccessData )
            }
            override fun getFreshData() {}
            override fun rxDataReady() : PublishSubject<List<CoursesItem>> { return rxDataReady }
            override fun rxDataError(): PublishSubject<String> { return rxDataError }
        }
        presenter = CourseListPresenterImpl( interactor, navigator, testScheduler )
        presenter.onCreate()
        presenter.onViewAttached( view )
        presenter.onResume()
    }

    @Test
    fun courseDetailsNavigation_test(){

        setupCourseDatailsNavigation_test()

        presenter.showDetails( courseListSuccessData[0] )

        verify( navigator , times(1)).showCoursesDetails( courseListSuccessData[0] )

    }


    val paramCaptor = argumentCaptor<CoursesItem>()

    @Test
    fun courseDetailsNavigation_test_negative(){

        setupCourseDatailsNavigation_test()

        presenter.showDetails( courseListSuccessData[0])

        verify( navigator, times(1)).showCoursesDetails( paramCaptor.capture() )

        paramCaptor.apply {
            assertThat( courseListSuccessData[1].key , `is`( not( this.firstValue.key )))
        }

    }

}