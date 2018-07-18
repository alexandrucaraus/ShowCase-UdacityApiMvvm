package eu.caraus.dynamo.application.ui.main.courselist

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import javax.inject.Inject

import eu.caraus.dynamo.application.common.schedulers.SchedulerProvider

class CourseListViewModelFactory

@Inject
constructor(private val dataModel: CourseListModel.IDataModel,
            private val scheduler: SchedulerProvider) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(CourseListViewModel::class.java)) {
            return CourseListViewModel(dataModel,scheduler) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
