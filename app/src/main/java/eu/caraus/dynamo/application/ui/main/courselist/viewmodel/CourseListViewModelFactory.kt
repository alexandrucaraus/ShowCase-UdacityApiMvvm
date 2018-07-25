package eu.caraus.dynamo.application.ui.main.courselist.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import javax.inject.Inject

import eu.caraus.dynamo.application.ui.main.courselist.model.CourseListModelContract
import io.reactivex.disposables.CompositeDisposable

class CourseListViewModelFactory

@Inject
constructor( private val repository: CourseListModelContract.IRepository,
             private val compositeDisposable: CompositeDisposable )
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(CourseListViewModel::class.java)) {
            return CourseListViewModel( repository , compositeDisposable ) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
