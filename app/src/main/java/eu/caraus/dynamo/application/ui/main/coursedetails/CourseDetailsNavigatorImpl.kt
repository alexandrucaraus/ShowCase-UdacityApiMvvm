package eu.caraus.dynamo.application.ui.main.coursedetails

import eu.caraus.dynamo.application.ui.main.znav.MainNavigation

class CourseDetailsNavigatorImpl (private val navigation: MainNavigation) : CourseDetailsContract.Navigator {


    override fun showCourseList() {
        navigation.navigateToCourseList()
    }

    override fun showCourseList( courseId : String ) {
        navigation.navigateToCourseList ( courseId )
    }

    override fun goBack() {
        navigation.goBack()
    }

}