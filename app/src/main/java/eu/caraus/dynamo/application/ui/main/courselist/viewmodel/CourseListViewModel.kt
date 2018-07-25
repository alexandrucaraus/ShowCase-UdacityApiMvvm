package eu.caraus.dynamo.application.ui.main.courselist.viewmodel

import android.arch.lifecycle.LiveData

import android.arch.lifecycle.ViewModel
import eu.caraus.dynamo.application.common.extensions.toLiveData
import eu.caraus.dynamo.application.common.retrofit.Outcome
import eu.caraus.dynamo.application.data.domain.udacity.CoursesItem
import eu.caraus.dynamo.application.ui.main.courselist.model.CourseListModelContract
import io.reactivex.disposables.CompositeDisposable



class CourseListViewModel( private val repository : CourseListModelContract.IRepository,
                           private val compositeDisposable: CompositeDisposable) : ViewModel() {



    val courseListOutcome: LiveData<Outcome<List<CoursesItem>>> by lazy {
        repository.dataFetchResult.toLiveData( compositeDisposable )
    }

    fun getData()      {
        repository.getDataLocal()
    }

    fun getFreshData() {
        repository.getDataRemote()
    }

    override fun onCleared(){
        super.onCleared()
        compositeDisposable.clear()
    }

}