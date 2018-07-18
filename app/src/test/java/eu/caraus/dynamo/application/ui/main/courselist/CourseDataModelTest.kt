package eu.caraus.dynamo.application.ui.main.courselist

import eu.caraus.dynamo.application.common.schedulers.TestSchedulerProvider
import eu.caraus.dynamo.application.service.udacity.UdacityCoursesService

import org.junit.Test


class CourseDataModelTest {

    private val scheduler = TestSchedulerProvider()

    @Test
    fun getDataModel () {

        val service = UdacityCoursesService()

        val dataModel = CourseDataModel ( service )


    }

}