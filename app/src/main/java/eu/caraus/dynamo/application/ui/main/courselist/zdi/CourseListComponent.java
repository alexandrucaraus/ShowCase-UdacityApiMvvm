package eu.caraus.dynamo.application.ui.main.courselist.zdi;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

import eu.caraus.dynamo.application.ui.main.courselist.CourseListFragment;


@Subcomponent( modules = {
        CourseListModule.class,
})
public interface CourseListComponent extends AndroidInjector<CourseListFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CourseListFragment>{}
}
