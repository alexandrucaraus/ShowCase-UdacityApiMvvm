package eu.caraus.dynamo.application.ui.main.courselist.model

import eu.caraus.dynamo.application.common.extensions.*
import eu.caraus.dynamo.application.common.retrofit.Outcome
import eu.caraus.dynamo.application.common.schedulers.SchedulerProvider
import eu.caraus.dynamo.application.data.domain.udacity.CoursesItem
import io.reactivex.disposables.CompositeDisposable

import io.reactivex.subjects.PublishSubject

class CourseListRepository(
        private val local     : CourseListModelContract.ICourseListLocalData,
        private val remote    : CourseListModelContract.ICourseListRemoteData,
        private val scheduler : SchedulerProvider,
        private val compositeDisposable: CompositeDisposable
) : CourseListModelContract.IRepository {

    override val dataFetchResult: PublishSubject<Outcome<List<CoursesItem>>> =
            PublishSubject.create<Outcome<List<CoursesItem>>>()

    override fun getData(){

    }

    override fun getDataLocal() {

        dataFetchResult.loading(true)

        local.getLocalData().subscribeOnIoObserveOnUi( scheduler ).subscribe(
                {

                 if( it.isEmpty() ) { getDataRemote() ; return@subscribe }

                 dataFetchResult.loading(false)

                 dataFetchResult.success(it)

                },{

                 dataFetchResult.loading(false)

                 dataFetchResult.failed(it)

                }).addTo( compositeDisposable)

    }

    override fun getDataRemote() {

        dataFetchResult.loading(true)

        remote.getRemoteData().subscribeOnIoObserveOnUi( scheduler).subscribe (
                {

                  dataFetchResult.loading(false)

                  local.setLocalData(it)

                  dataFetchResult.success(it)

                },{

                  dataFetchResult.loading(false)

                  dataFetchResult.failed(it)

              }).addTo( compositeDisposable)

    }

    override fun handleErrorData( error: String) {

    }

    override fun handleErrorGeneral( error: Throwable) {

        dataFetchResult.failed( error )

    }

}