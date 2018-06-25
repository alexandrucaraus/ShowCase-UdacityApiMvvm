package eu.caraus.dynamo.application.ui.main.courselist

import android.arch.lifecycle.LifecycleObserver
import android.widget.ImageView
import eu.caraus.dynamo.application.domain.udacity.CoursesItem
import eu.caraus.dynamo.application.ui.base.BaseContract
import io.reactivex.subjects.PublishSubject

interface CourseListContract : BaseContract {

    interface Presenter : BaseContract.BasePresenter<View>, LifecycleObserver {

        fun showDetails( courseItem : CoursesItem )
        fun showDetails( courseItem : CoursesItem, sharedElement : ImageView )

        fun adapterEmpty()
        fun adapterNotEmpty()

        fun refresh()

    }

    interface View : BaseContract.BaseView {

        fun addItems( courseList : List<CoursesItem>)

        fun showPlaceholder()
        fun hidePlaceholder()

        fun showProgress()
        fun hideProgress()

        fun showServiceCallError(message: String )

    }

    interface Interactor {
        fun getData()
        fun getFreshData()
        fun rxDataReady() : PublishSubject<List<CoursesItem>>
        fun rxDataError() : PublishSubject<String>
    }

    interface Navigator {
        fun showCoursesDetails( courseId : String )
        fun showCoursesDetails( courseItem: CoursesItem)
        fun showCoursesDetails( courseItem: CoursesItem, sharedElement: ImageView)
    }

}