package eu.caraus.dynamo.application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import eu.caraus.dynamo.application.ui.main.zdi.MainActivityBuilder;

@Singleton
@Component(
        modules =  {

                AndroidSupportInjectionModule.class,
                AppModule.class,

                MainActivityBuilder.class,

        }
)
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(App application);

        AppComponent build();

    }

    @Override
    void inject(App app);

}
