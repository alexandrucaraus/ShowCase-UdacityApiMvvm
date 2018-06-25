package eu.caraus.dynamo.application.common.schedulers;

import io.reactivex.Scheduler;

public interface SchedulerProvider {

    Scheduler ui();
    Scheduler io();
    Scheduler computation();

}
