package eu.caraus.dynamo.application.ui.main.courselist.zdi;

import android.support.v4.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

import eu.caraus.dynamo.application.ui.main.courselist.CourseListFragment;

@Module(subcomponents = {
        CourseListComponent.class
})
public abstract class CourseListBuilder {

    @Binds
    @IntoMap
    @FragmentKey(CourseListFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment>
    bindCourseList(CourseListComponent.Builder builder);


}
