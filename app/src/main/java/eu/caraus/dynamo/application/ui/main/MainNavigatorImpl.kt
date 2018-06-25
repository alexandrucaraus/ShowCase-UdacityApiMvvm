package eu.caraus.dynamo.application.ui.main

import eu.caraus.dynamo.application.ui.main.znav.MainNavigation

class MainNavigatorImpl( private val navigation : MainNavigation) : MainContract.Navigator {

    override fun showCourseList() {
        navigation.navigateToCourseList()
    }

    override fun showCourseDetails(courseId: String) {
        navigation.navigateToCourseDetails( courseId )
    }

    override fun goBack(): Boolean {
        return navigation.goBack()
    }

}