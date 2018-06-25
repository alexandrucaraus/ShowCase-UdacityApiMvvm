package eu.caraus.dynamo.application.ui.main.zdi;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import eu.caraus.dynamo.application.ui.main.MainActivityViewImpl;
import eu.caraus.dynamo.application.ui.main.coursedetails.zdi.CourseDetailsBuilder;
import eu.caraus.dynamo.application.ui.main.courselist.zdi.CourseListBuilder;

@MainActivityScope
@Subcomponent( modules = {

        MainActivityModule.class,

        CourseListBuilder.class,
        CourseDetailsBuilder.class,

})
public interface MainActivityComponent extends AndroidInjector<MainActivityViewImpl> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivityViewImpl>{}

}
