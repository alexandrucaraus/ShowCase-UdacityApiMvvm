package eu.caraus.dynamo.application.ui.main.coursedetails

import android.arch.lifecycle.LifecycleObserver
import eu.caraus.dynamo.application.ui.base.BaseContract

interface CourseDetailsContract : BaseContract {

    interface Presenter : BaseContract.BasePresenter<View>, LifecycleObserver {

        fun home()
        fun home( courseId : String )

        fun goBack()

    }

    interface View : BaseContract.BaseView

    interface Interactor

    interface Navigator {

        fun showCourseList()
        fun showCourseList( courseId : String )

        fun goBack()
    }

}