package eu.caraus.dynamo.application.ui.main.courselist.zdi;

import android.arch.lifecycle.ViewModelProviders;

import dagger.Module;
import dagger.Provides;

import eu.caraus.dynamo.application.common.schedulers.SchedulerProvider;
import eu.caraus.dynamo.application.service.udacity.UdacityCoursesService;
import eu.caraus.dynamo.application.ui.main.courselist.CourseDataModel;
import eu.caraus.dynamo.application.ui.main.courselist.CourseListFragViewImpl;
import eu.caraus.dynamo.application.ui.main.courselist.CourseListModel;
import eu.caraus.dynamo.application.ui.main.courselist.CourseListViewModel;
import eu.caraus.dynamo.application.ui.main.courselist.CourseListViewModelFactory;


@Module
public class CourseListModule {

    @Provides
    CourseListViewModel providesViewModel( CourseListFragViewImpl activity,
                                           CourseListViewModelFactory factory ){

        return ViewModelProviders.of( activity, factory).get(CourseListViewModel.class);
    }

    @Provides
    CourseListViewModelFactory providesViewModelFactory( CourseListModel.IDataModel  service ,
                                                         SchedulerProvider scheduler    ){
        return new CourseListViewModelFactory( service, scheduler );
    }

    @Provides
    CourseListModel.IDataModel providesDataModel(UdacityCoursesService service){
        return new CourseDataModel( service );
    }

}
