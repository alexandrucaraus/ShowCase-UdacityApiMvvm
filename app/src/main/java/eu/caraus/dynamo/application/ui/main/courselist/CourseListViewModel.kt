package eu.caraus.dynamo.application.ui.main.courselist

import android.arch.lifecycle.MutableLiveData

import eu.caraus.dynamo.application.common.schedulers.SchedulerProvider

import android.arch.lifecycle.ViewModel
import eu.caraus.dynamo.application.domain.udacity.CoursesItem
import io.reactivex.disposables.Disposable


class CourseListViewModel(private val dataModel : CourseListModel.IDataModel,
                          private val scheduler : SchedulerProvider          ) : ViewModel() {

    var courseListLifeData  : MutableLiveData<MutableList<CoursesItem>>? = null

    private var dataDispose         : Disposable? = null
    private var dataRefreshDispose  : Disposable? = null

    init {
        courseListLifeData = MutableLiveData()
        getData()
    }

    private fun getData() {
        dataDispose = dataModel.rxCourseListData().subscribeOn( scheduler.io() )
                 .observeOn( scheduler.ui())
                 .subscribe {
                    courseListLifeData?.value = it
                    dataDispose?.dispose()
                 }
    }

    fun getFreshData(){
        dataRefreshDispose = dataModel.rxCourseListFreshData().subscribeOn( scheduler.io() )
                .observeOn( scheduler.ui())
                .subscribe {
                    courseListLifeData?.value = it
                    dataRefreshDispose?.dispose()
                }
    }

    override fun onCleared(){
        super.onCleared()
        dataDispose?.dispose()
        dataRefreshDispose?.dispose()
    }

}