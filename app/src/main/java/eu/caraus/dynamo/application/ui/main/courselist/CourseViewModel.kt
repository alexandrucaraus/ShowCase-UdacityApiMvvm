package eu.caraus.dynamo.application.ui.main.courselist

import android.arch.lifecycle.ViewModel
import eu.caraus.dynamo.application.domain.udacity.CoursesItem

class CourseViewModel : ViewModel() {

    lateinit var coursesList : MutableList<CoursesItem>

    fun getCourses() : MutableList<CoursesItem>? {
        if( coursesList == null){
            coursesList = loadCourses()
        }
        return coursesList
    }

    private fun loadCourses() : MutableList<CoursesItem> {
        return coursesList
    }

}
