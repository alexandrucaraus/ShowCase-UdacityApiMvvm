package eu.caraus.dynamo.application.ui.main.coursedetails.zdi;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

import eu.caraus.dynamo.application.ui.main.coursedetails.CourseDetailsFragViewImpl;

@Module( subcomponents = {
        CourseDetailsComponent.class
})
public abstract class CourseDetailsBuilder {

    @Binds
    @IntoMap
    @FragmentKey(CourseDetailsFragViewImpl.class)
    abstract AndroidInjector.Factory<? extends Fragment>
    bindCourseDetails(CourseDetailsComponent.Builder builder);

}