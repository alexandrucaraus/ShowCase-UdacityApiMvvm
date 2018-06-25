package eu.caraus.dynamo.application.ui.main.zdi;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import eu.caraus.dynamo.application.ui.main.MainActivityViewImpl;
import eu.caraus.dynamo.application.ui.main.coursedetails.zdi.CourseDetailsComponent;
import eu.caraus.dynamo.application.ui.main.courselist.zdi.CourseListComponent;

@Module (subcomponents = {

        CourseListComponent.class,

        CourseDetailsComponent.class,

})
public abstract class MainActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainActivityViewImpl.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindMainActivity(MainActivityComponent.Builder builder);

}