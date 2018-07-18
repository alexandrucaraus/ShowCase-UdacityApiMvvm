package eu.caraus.dynamo.application.ui.main.courselist


import eu.caraus.dynamo.application.domain.udacity.CoursesItem
import io.reactivex.Observable

interface CourseListModel {

    interface IDataModel {
        fun rxCourseListData() : Observable<MutableList<CoursesItem>>
        fun rxCourseListFreshData() : Observable<MutableList<CoursesItem>>
    }

}