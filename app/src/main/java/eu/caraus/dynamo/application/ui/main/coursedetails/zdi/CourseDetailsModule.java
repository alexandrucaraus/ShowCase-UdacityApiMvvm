package eu.caraus.dynamo.application.ui.main.coursedetails.zdi;


import android.arch.lifecycle.ViewModelProviders;

import dagger.Module;
import dagger.Provides;

import eu.caraus.dynamo.application.ui.main.coursedetails.CourseDetailsFragViewImpl;
import eu.caraus.dynamo.application.ui.main.coursedetails.CourseDetailsViewModel;
import eu.caraus.dynamo.application.ui.main.coursedetails.CourseDetailsViewModelFactory;


@Module
public class CourseDetailsModule {

    @Provides
    CourseDetailsViewModel providesCourseDetailsViewModel(CourseDetailsFragViewImpl view,
                                                          CourseDetailsViewModelFactory factory){
        return ViewModelProviders.of( view, factory ).get(CourseDetailsViewModel.class);
    }

    @Provides
    CourseDetailsViewModelFactory providesCourseListViewModelFactory(){
        return new CourseDetailsViewModelFactory();
    }

}
