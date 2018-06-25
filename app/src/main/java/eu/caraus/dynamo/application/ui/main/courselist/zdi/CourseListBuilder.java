package eu.caraus.dynamo.application.ui.main.courselist.zdi;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

import eu.caraus.dynamo.application.ui.main.courselist.CourseListFragViewImpl;

@Module(subcomponents = {
        CourseListComponent.class
})
public abstract class CourseListBuilder {

    @Binds
    @IntoMap
    @FragmentKey(CourseListFragViewImpl.class)
    abstract AndroidInjector.Factory<? extends Fragment>
    bindCourseList(CourseListComponent.Builder builder);


}
