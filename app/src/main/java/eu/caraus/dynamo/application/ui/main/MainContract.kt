package eu.caraus.dynamo.application.ui.main


import android.arch.lifecycle.LifecycleObserver

import eu.caraus.dynamo.application.ui.base.BaseContract


interface MainContract : BaseContract {

    interface Presenter : BaseContract.BasePresenter<View>, LifecycleObserver {
        fun onBack() : Boolean
    }

    interface View : BaseContract.BaseView

    interface Interactor

    interface Navigator {

        fun goBack() : Boolean

        fun showCourseList()
        fun showCourseDetails( courseId : String )

    }

}