package eu.caraus.dynamo.application.ui.main.courselist

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.util.Log
import android.widget.ImageView
import eu.caraus.dynamo.application.common.schedulers.SchedulerProvider
import eu.caraus.dynamo.application.domain.udacity.CoursesItem

import io.reactivex.disposables.Disposable


class CourseListPresenterImpl( val interactor : CourseListContract.Interactor ,
                               val navigator  : CourseListContract.Navigator  ,
                               private val scheduler  : SchedulerProvider ) : CourseListContract.Presenter {

    private var view : CourseListContract.View? = null

    private var disposeData : Disposable? = null
    private var disposeErr  : Disposable? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {

        val v = interactor.rxDataError()

        disposeErr = interactor.rxDataError()
                               .observeOn( scheduler.ui())
                               .subscribe{
                                   showError( it )
                               }

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        subscribeAndQueryData()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        disposeData?.dispose()
        disposeErr?.dispose()
    }

    private fun subscribeAndQueryData(){

        val v = interactor.rxDataReady()

        disposeData = interactor.rxDataReady()
                .observeOn( scheduler.ui() )
                .doOnSubscribe {
                    view?.showProgress()
                }
                .doAfterNext {
                    view?.hideProgress()
                }
                .subscribe {
                    addItems( it )
                }

        interactor.getData()

    }

    private fun addItems( list: List<CoursesItem> ){

        if ( list.isEmpty() ) view?.showPlaceholder() else view?.hidePlaceholder()

        view?.addItems( list )

    }

    private fun showError( error : String ){
        view?.hideProgress()
        view?.showServiceCallError( error )
    }

    override fun refresh() {
        interactor.getFreshData()
    }

    override fun showDetails( courseItem: CoursesItem) {
        navigator.showCoursesDetails( courseItem )
    }

    override fun showDetails(courseItem: CoursesItem, sharedElement: ImageView) {
        navigator.showCoursesDetails( courseItem, sharedElement)
    }

    override fun adapterEmpty() {
        view?.showPlaceholder()
    }

    override fun adapterNotEmpty() {
        view?.hidePlaceholder()
    }

    override fun onViewAttached( view: CourseListContract.View?) {
        this.view = view
    }

    override fun onViewDetached( detach: Boolean) {
        this.view = null
    }

    fun log( msg : String ){
        Log.d("CourseListPresenterImpl", msg)
    }

}