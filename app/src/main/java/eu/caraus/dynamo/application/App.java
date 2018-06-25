package eu.caraus.dynamo.application;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class App extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {

        AppComponent appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();

        appComponent.inject(this);

        return appComponent;
    }

}
