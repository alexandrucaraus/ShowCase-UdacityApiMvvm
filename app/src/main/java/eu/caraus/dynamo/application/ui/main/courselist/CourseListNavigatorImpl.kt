package eu.caraus.dynamo.application.ui.main.courselist

import android.widget.ImageView
import eu.caraus.dynamo.application.domain.udacity.CoursesItem
import eu.caraus.dynamo.application.ui.main.znav.MainNavigation

class CourseListNavigatorImpl( private val navigation : MainNavigation ) : CourseListContract.Navigator {

    override fun showCoursesDetails(courseId: String) {
        navigation.navigateToCourseDetails( courseId)
    }

    override fun showCoursesDetails(courseItem: CoursesItem) {
        navigation.navigateToCourseDetails( courseItem)
    }

    override fun showCoursesDetails(courseItem: CoursesItem, sharedElement: ImageView) {
        navigation.navigateToCourseDetails( courseItem, sharedElement )
    }

}