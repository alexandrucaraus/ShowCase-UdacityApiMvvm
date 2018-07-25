package eu.caraus.dynamo.application.common.extensions

import eu.caraus.dynamo.application.common.schedulers.SchedulerProvider
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


fun Completable.subscribeOnIoObserveOnUi(scheduler: SchedulerProvider): Completable {
    return this.subscribeOn(scheduler.io()).observeOn( scheduler.ui())
}

/**
 * Extension function to subscribe on the background thread and observe on the main thread for a [Flowable]
 * */
fun <T> Flowable<T>.subscribeOnIoObserveOnUi(scheduler: SchedulerProvider): Flowable<T> {
    return this.subscribeOn(scheduler.io())
            .observeOn( scheduler.ui())
}

/**
 * Extension function to subscribe on the background thread and observe on the main thread  for a [Single]
 * */
fun <T> Single<T>.subscribeOnIoObserveOnUi(scheduler: SchedulerProvider): Single<T> {
    return this.subscribeOn(scheduler.io())
            .observeOn( scheduler.ui())
}

/**
 * Extension function to subscribe on the background thread and observe on the main thread for a [Observable]
 * */
fun <T> Observable<T>.subscribeOnIoObserveOnUi(scheduler: SchedulerProvider): Observable<T> {
    return this.subscribeOn(scheduler.io())
            .observeOn( scheduler.ui())
}

/**
 * Extension function to subscribe on the background thread for a Flowable
 * */
fun <T> Flowable<T>.subscribeOnIo(scheduler: SchedulerProvider): Flowable<T> {
    return this.subscribeOn(scheduler.io())
}

/**
 * Extension function to subscribe on the background thread for a Completable
 * */
fun Completable.subscribeOnIo(scheduler: SchedulerProvider): Completable {
    return this.subscribeOn(scheduler.io())
}

/**
 * Extension function to subscribe on the background thread for a Observable
 * */
fun <T> Observable<T>.subscribeOnIo(scheduler: SchedulerProvider): Observable<T> {
    return this.subscribeOn(scheduler.io())
}

/**
 * Extension function to add a Disposable to a CompositeDisposable
 */
fun Disposable.addTo(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}