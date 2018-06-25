package eu.caraus.dynamo.application.ui.main.coursedetails.zdi;

import dagger.Module;
import dagger.Provides;
import eu.caraus.dynamo.application.ui.main.coursedetails.CourseDetailsContract;
import eu.caraus.dynamo.application.ui.main.coursedetails.CourseDetailsInteractorImpl;
import eu.caraus.dynamo.application.ui.main.coursedetails.CourseDetailsNavigatorImpl;
import eu.caraus.dynamo.application.ui.main.coursedetails.CourseDetailsPresenterImpl;
import eu.caraus.dynamo.application.ui.main.znav.MainNavigation;

@Module
public class CourseDetailsModule {

    @Provides
    CourseDetailsContract.Presenter providesPresenter(CourseDetailsContract.Interactor interactor,
                                                      CourseDetailsContract.Navigator navigator){
        return new CourseDetailsPresenterImpl(interactor, navigator);
    }

//    @Provides
//    CourseDetailsContract.Interactor providesInteractor(){
//        return new CourseDetailsInteractorImpl();
//    }
//
//    @Provides
//    CourseDetailsContract.Navigator providesNavigator(MainNavigation navigation){
//        return new CourseDetailsNavigatorImpl( navigation );
//    }

}
