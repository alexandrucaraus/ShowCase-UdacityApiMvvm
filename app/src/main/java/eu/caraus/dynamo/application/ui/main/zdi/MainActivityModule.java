package eu.caraus.dynamo.application.ui.main.zdi;

import dagger.Module;
import dagger.Provides;
import eu.caraus.dynamo.R;
import eu.caraus.dynamo.application.common.schedulers.SchedulerProvider;
import eu.caraus.dynamo.application.service.udacity.UdacityCoursesService;
import eu.caraus.dynamo.application.ui.main.MainActivityViewImpl;
import eu.caraus.dynamo.application.ui.main.MainContract;
import eu.caraus.dynamo.application.ui.main.MainInteractorImpl;
import eu.caraus.dynamo.application.ui.main.MainNavigatorImpl;
import eu.caraus.dynamo.application.ui.main.MainPresenterImpl;
import eu.caraus.dynamo.application.ui.main.coursedetails.CourseDetailsContract;
import eu.caraus.dynamo.application.ui.main.coursedetails.CourseDetailsInteractorImpl;
import eu.caraus.dynamo.application.ui.main.coursedetails.CourseDetailsNavigatorImpl;
import eu.caraus.dynamo.application.ui.main.courselist.CourseListContract;
import eu.caraus.dynamo.application.ui.main.courselist.CourseListInteractorImpl;
import eu.caraus.dynamo.application.ui.main.courselist.CourseListNavigatorImpl;
import eu.caraus.dynamo.application.ui.main.courselist.CourseListPresenterImpl;
import eu.caraus.dynamo.application.ui.main.znav.MainNavigation;


@Module
public class MainActivityModule {

    @Provides
    @MainActivityScope
    MainContract.Presenter providesPresenter( MainContract.Interactor interactor,
                                              MainContract.Navigator  navigator){
        return new MainPresenterImpl( interactor, navigator );
    }

    @Provides
    @MainActivityScope
    MainContract.Interactor providesInteractor(UdacityCoursesService service){
        return new MainInteractorImpl( service );
    }

    @Provides
    @MainActivityScope
    MainContract.Navigator providesNavigator(MainNavigation navigation){
        return new MainNavigatorImpl( navigation );
    }

    @Provides
    @MainActivityScope
    CourseListContract.Presenter providesListPresenter(
            CourseListContract.Interactor interactor,
            CourseListContract.Navigator navigator,
            SchedulerProvider scheduler){
        return new CourseListPresenterImpl(interactor, navigator, scheduler);
    }

    @Provides
    @MainActivityScope
    CourseListContract.Interactor providesListInteractor(UdacityCoursesService service){
        return new CourseListInteractorImpl( service );
    }

    @Provides
    @MainActivityScope
    CourseListContract.Navigator providesListNavigator( MainNavigation navigation){
        return new CourseListNavigatorImpl( navigation );
    }

    @Provides
    @MainActivityScope
    CourseDetailsContract.Interactor providesDetailsInteractor(){
        return new CourseDetailsInteractorImpl();
    }

    @Provides
    @MainActivityScope
    CourseDetailsContract.Navigator providesDetailsNavigator(MainNavigation navigation){
        return new CourseDetailsNavigatorImpl( navigation );
    }

    @Provides
    @MainActivityScope
    MainNavigation providesNavigation(MainActivityViewImpl activityView) {
        return new MainNavigation( activityView, R.id.main_fragment_container );
    }

}
