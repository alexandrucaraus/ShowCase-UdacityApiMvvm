package eu.caraus.dynamo.application.ui.main.courselist.zdi;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

import eu.caraus.dynamo.application.ui.main.courselist.CourseListFragViewImpl;


@Subcomponent( modules = {
        CourseListModule.class,
})
public interface CourseListComponent extends AndroidInjector<CourseListFragViewImpl> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CourseListFragViewImpl>{}
}
