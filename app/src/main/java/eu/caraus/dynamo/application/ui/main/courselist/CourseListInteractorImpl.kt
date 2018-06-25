package eu.caraus.dynamo.application.ui.main.courselist


import android.util.Log
import eu.caraus.dynamo.application.domain.udacity.CoursesItem
import eu.caraus.dynamo.application.domain.udacity.UdacityCourses
import eu.caraus.dynamo.application.service.udacity.UdacityCoursesService
import io.reactivex.subjects.PublishSubject

class CourseListInteractorImpl( private val service: UdacityCoursesService) : CourseListContract.Interactor {


    private var rxDataReady = PublishSubject.create<List<CoursesItem>>()

    private var rxDataError = PublishSubject.create<String>()

    private var courseList : MutableList<CoursesItem>? = null

    override fun getData() {

        courseList?.let {
            rxDataReady.onNext( it )
            return
        }

        service.getCourses(

                object : UdacityCoursesService.UdacityCoursesCallback {

                    override fun onData( courses: UdacityCourses? ) {

                        if( courses?.courses != null ) {

                            courseList = courses.courses

                            rxDataReady.onNext( courses.courses )

                        } else {

                            rxDataError.onNext("courses is null :( ")

                        }
                    }

                    override fun onDataError(error: String?) {
                        rxDataError.onNext( "Data Error : $error" )
                    }

                    override fun onFailure(throwable: Throwable?) {
                        rxDataError.onNext( "Data Failure ${throwable?.localizedMessage}")
                    }
                }
        )
    }

    override fun getFreshData() {

        service.getCourses(

                object : UdacityCoursesService.UdacityCoursesCallback {

                    override fun onData( courses: UdacityCourses? ) {

                        if( courses?.courses != null ) {

                            courseList = courses.courses

                            rxDataReady.onNext( courses.courses )

                        } else {

                            rxDataError.onNext("courses is null :( ")

                        }
                    }

                    override fun onDataError(error: String?) {
                        rxDataError.onNext( "Data Error : $error" )
                    }

                    override fun onFailure(throwable: Throwable?) {
                        rxDataError.onNext( "Data Failure ${throwable?.localizedMessage}")
                    }
                }
        )

    }

    override fun rxDataReady(): PublishSubject<List<CoursesItem>> {
        return rxDataReady
    }

    override fun rxDataError(): PublishSubject<String> {
        return rxDataError
    }

    fun log( msg : String ){
        Log.d("CourseListInteractorImp", msg)
    }

}