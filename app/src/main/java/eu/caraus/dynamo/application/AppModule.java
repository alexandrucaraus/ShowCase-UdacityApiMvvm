package eu.caraus.dynamo.application;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import eu.caraus.dynamo.application.common.schedulers.AppSchedulerProvider;
import eu.caraus.dynamo.application.common.schedulers.SchedulerProvider;
import eu.caraus.dynamo.application.data.local.Database;
import eu.caraus.dynamo.application.data.remote.udacity.UdacityCoursesService;
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

    @Provides
    @Singleton
    public static Database providesDatabase(Context context){
        return Room.databaseBuilder(   context ,
                                      Database.class,
                                      Database.DATABASE_NAME )
                    .fallbackToDestructiveMigration()
                    .build();

    }

}
