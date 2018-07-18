package eu.caraus.dynamo.application.ui.main.courselist


import eu.caraus.dynamo.application.domain.udacity.CoursesItem
import eu.caraus.dynamo.application.service.udacity.UdacityCoursesService
import io.reactivex.Observable


class CourseDataModel( private val service: UdacityCoursesService ) : CourseListModel.IDataModel {

    var data : MutableList<CoursesItem>? = null

    override fun rxCourseListData() : Observable<MutableList<CoursesItem>> {
        return Observable.fromCallable {
            data?.let {
                data
            } ?: run {
                data =  service.udacityCourses?.courses
            }
            data
        }
    }

    override fun rxCourseListFreshData(): Observable<MutableList<CoursesItem>> {
        return Observable.fromCallable {

            data =  service.udacityCourses?.courses

            data
        }
    }

}