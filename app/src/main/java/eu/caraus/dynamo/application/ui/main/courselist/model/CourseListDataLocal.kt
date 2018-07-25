package eu.caraus.dynamo.application.ui.main.courselist.model

import eu.caraus.dynamo.application.common.schedulers.SchedulerProvider
import eu.caraus.dynamo.application.data.local.Database
import eu.caraus.dynamo.application.data.domain.udacity.CoursesItem
import io.reactivex.Flowable
import kotlin.concurrent.thread

class CourseListLocalData (
        private val database  : Database,
        private val scheduler : SchedulerProvider
)
    : CourseListModelContract.ICourseListLocalData {

    override fun getLocalData(): Flowable<List<CoursesItem>> {
        return database.coursesItemDao().getAll()
    }

    override fun setLocalData(list: List<CoursesItem>) {
        thread( start = true ) {
            database.coursesItemDao().upsertAll(list)
        }
    }

}