package eu.caraus.dynamo.application.ui.main.coursedetails.zdi;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

import eu.caraus.dynamo.application.ui.main.coursedetails.CourseDetailsFragViewImpl;


@Subcomponent(modules = {
        CourseDetailsModule.class,
})
public interface CourseDetailsComponent extends AndroidInjector<CourseDetailsFragViewImpl> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<CourseDetailsFragViewImpl>{}

}