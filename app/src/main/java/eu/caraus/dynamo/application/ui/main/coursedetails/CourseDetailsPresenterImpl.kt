package eu.caraus.dynamo.application.ui.main.coursedetails

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log

class CourseDetailsPresenterImpl ( val interactor : CourseDetailsContract.Interactor,
                                   val navigator  : CourseDetailsContract.Navigator ) : CourseDetailsContract.Presenter {

    var view : CourseDetailsContract.View? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){

    }

    override fun home( courseId : String) {
        navigator.showCourseList( courseId )
    }

    override fun home() {
        navigator.showCourseList()
    }

    override fun goBack() {
        navigator.goBack()
    }

    override fun onViewAttached( view: CourseDetailsContract.View? ) {
        this.view = view
    }

    override fun onViewDetached( detach: Boolean ) {
        this.view = null
    }

}