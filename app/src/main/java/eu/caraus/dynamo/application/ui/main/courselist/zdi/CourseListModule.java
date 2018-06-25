package eu.caraus.dynamo.application.ui.main.courselist.zdi;

import dagger.Module;
import dagger.Provides;
import eu.caraus.dynamo.R;
import eu.caraus.dynamo.application.common.schedulers.SchedulerProvider;
import eu.caraus.dynamo.application.service.udacity.UdacityCoursesService;
import eu.caraus.dynamo.application.ui.main.MainActivityViewImpl;
import eu.caraus.dynamo.application.ui.main.courselist.CourseListContract;
import eu.caraus.dynamo.application.ui.main.courselist.CourseListInteractorImpl;
import eu.caraus.dynamo.application.ui.main.courselist.CourseListNavigatorImpl;
import eu.caraus.dynamo.application.ui.main.courselist.CourseListPresenterImpl;
import eu.caraus.dynamo.application.ui.main.zdi.MainActivityScope;
import eu.caraus.dynamo.application.ui.main.znav.MainNavigation;


@Module
public class CourseListModule {



//    @Provides
//    CourseListContract.Interactor providesInteractor(UdacityCoursesService service){
//        return new CourseListInteractorImpl( service );
//    }
//
//    @Provides
//    CourseListContract.Navigator providesNavigator( MainNavigation navigation){
//        return new CourseListNavigatorImpl( navigation );
//    }


}
