package eu.caraus.dynamo.application.ui.main.courselist.model

import eu.caraus.dynamo.application.data.domain.udacity.CoursesItem
import eu.caraus.dynamo.application.data.remote.udacity.UdacityCoursesService

import io.reactivex.Single


class CourseListDataRemote ( val service : UdacityCoursesService )
    : CourseListModelContract.ICourseListRemoteData {

    override fun getRemoteData(): Single<List<CoursesItem>> {
        return service.get().coursesItemList
    }

}

