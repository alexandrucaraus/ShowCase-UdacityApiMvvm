package eu.caraus.dynamo.application;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import eu.caraus.dynamo.application.common.schedulers.AppSchedulerProvider;
import eu.caraus.dynamo.application.common.schedulers.SchedulerProvider;
import eu.caraus.dynamo.application.service.udacity.UdacityCoursesService;
import eu.caraus.dynamo.application.ui.main.zdi.MainActivityComponent;

@Module(
        subcomponents = {
                MainActivityComponent.class,
        }
)
public class AppModule {

    @Provides
    @Singleton
    public static Context providesApplicationContext(App app){
        return app;
    }

    @Provides
    @Singleton
    public static UdacityCoursesService provideUdacityCoursesService(){
        return new UdacityCoursesService();
    }

    @Provides
    @Singleton
    public static SchedulerProvider providesScheduler(){
        return new AppSchedulerProvider();
    }

}
