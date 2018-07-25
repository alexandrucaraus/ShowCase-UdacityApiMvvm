package eu.caraus.dynamo.application.ui.main.courselist.model


import eu.caraus.dynamo.application.common.retrofit.Outcome
import eu.caraus.dynamo.application.data.domain.udacity.CoursesItem
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.subjects.PublishSubject

interface CourseListModelContract {

    interface IRepository {

        val dataFetchResult: PublishSubject<Outcome<List<CoursesItem>>>

        fun getData()
        fun getDataLocal()
        fun getDataRemote()

        fun handleErrorData    ( error : String    )
        fun handleErrorGeneral ( error : Throwable )

    }

    interface ICourseListLocalData  {
        fun getLocalData()  : Flowable<List<CoursesItem>>
        fun setLocalData( list : List<CoursesItem>)
    }

    interface ICourseListRemoteData {
        fun getRemoteData() : Single<List<CoursesItem>>

    }

}