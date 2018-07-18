package eu.caraus.dynamo.application.ui.main.coursedetails

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider


class CourseDetailsViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(CourseDetailsViewModel::class.java)) {
            return CourseDetailsViewModel() as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
