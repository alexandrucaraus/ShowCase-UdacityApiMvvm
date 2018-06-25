package eu.caraus.dynamo.application.common.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class TestSchedulerProvider implements SchedulerProvider {

    @Override
    public Scheduler ui() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler io() {
        return Schedulers.trampoline();
    }

    @Override
    public Scheduler computation() {
        return Schedulers.trampoline();
    }

}
