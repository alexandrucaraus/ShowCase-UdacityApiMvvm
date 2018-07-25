package eu.caraus.dynamo.application.ui.main.courselist.zdi;

import android.arch.lifecycle.ViewModelProviders;

import dagger.Module;
import dagger.Provides;

import eu.caraus.dynamo.application.common.schedulers.SchedulerProvider;
import eu.caraus.dynamo.application.data.local.Database;
import eu.caraus.dynamo.application.data.remote.udacity.UdacityCoursesService;
import eu.caraus.dynamo.application.ui.main.courselist.CourseListFragment;
import eu.caraus.dynamo.application.ui.main.courselist.model.CourseListDataRemote;
import eu.caraus.dynamo.application.ui.main.courselist.model.CourseListLocalData;
import eu.caraus.dynamo.application.ui.main.courselist.model.CourseListModelContract;
import eu.caraus.dynamo.application.ui.main.courselist.model.CourseListRepository;
import eu.caraus.dynamo.application.ui.main.courselist.viewmodel.CourseListViewModel;
import eu.caraus.dynamo.application.ui.main.courselist.viewmodel.CourseListViewModelFactory;
import io.reactivex.disposables.CompositeDisposable;


@Module
public class CourseListModule {

    @Provides
    CourseListViewModel providesViewModel(CourseListFragment activity,
                                          CourseListViewModelFactory factory ){

        return ViewModelProviders.of( activity, factory).get(CourseListViewModel.class);
    }

    @Provides
    CourseListViewModelFactory providesViewModelFactory(CourseListModelContract.IRepository  repository,
                                                        CompositeDisposable compositeDisposable){
        return new CourseListViewModelFactory( repository, compositeDisposable );
    }

    @Provides
    CourseListModelContract.IRepository providesRepository(
            CourseListModelContract.ICourseListLocalData local,
            CourseListModelContract.ICourseListRemoteData remote,
            SchedulerProvider scheduler,
            CompositeDisposable compositeDisposable){
        return new CourseListRepository( local, remote, scheduler, compositeDisposable);
    }

    @Provides
    CourseListModelContract.ICourseListLocalData providesLocalData( Database database,
                                                                    SchedulerProvider scheduler){
        return new CourseListLocalData( database, scheduler );
    }

    @Provides
    CourseListModelContract.ICourseListRemoteData providesRemoteData(UdacityCoursesService service){
        return new CourseListDataRemote( service);
    }

    @Provides
    CompositeDisposable providesCompositeDisposable(){
        return new CompositeDisposable();
    }

}
