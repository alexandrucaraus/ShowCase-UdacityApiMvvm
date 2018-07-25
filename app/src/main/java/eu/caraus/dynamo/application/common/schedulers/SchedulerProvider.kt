package eu.caraus.dynamo.application.common.schedulers

import io.reactivex.Scheduler

interface SchedulerProvider {

    fun ui()          : Scheduler

    fun io()          : Scheduler

    fun computation() : Scheduler

}
