package eu.caraus.dynamo.application.ui.main.zdi;

import dagger.Module;
import dagger.Provides;
import eu.caraus.dynamo.R;
import eu.caraus.dynamo.application.ui.main.MainActivityViewImpl;
import eu.caraus.dynamo.application.ui.main.znav.MainNavigation;


@Module
public class MainActivityModule {

    @Provides
    @MainActivityScope
    MainNavigation providesNavigation(MainActivityViewImpl activityView) {
        return new MainNavigation( activityView, R.id.main_fragment_container );
    }

}
