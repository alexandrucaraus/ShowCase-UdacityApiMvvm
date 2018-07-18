package eu.caraus.dynamo.application.service.udacity;

import eu.caraus.dynamo.application.domain.udacity.UdacityCourses;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UdacityCoursesService {

    public static final String  TAG = UdacityCoursesService.class.getSimpleName();

    private UdacityCoursesApi udacityCoursesApi;

    public UdacityCoursesService() {

        udacityCoursesApi = (new UdacityCoursesApiClient()).getClient().create(UdacityCoursesApi.class);

    }

    public void getUdacityCourses(UdacityCoursesCallback coursesCallback) {

        udacityCoursesApi.getUdacityCoursesList().enqueue(
                new Callback<UdacityCourses>() {
                    @Override
                    public void onResponse(Call<UdacityCourses> call, Response<UdacityCourses> response) {
                        if( response.isSuccessful() ) {
                            coursesCallback.onData( response.body() );
                        } else {
                            coursesCallback.onDataError( response.errorBody().toString() );
                        }
                    }

                    @Override
                    public void onFailure(Call<UdacityCourses> call, Throwable t) {
                        coursesCallback.onFailure( t );
                    }
                }
        );

    }

    public UdacityCourses getUdacityCourses() throws Exception {

        Response<UdacityCourses> courses
                = udacityCoursesApi.getUdacityCoursesList().execute();

        if( courses.isSuccessful() ){
            return courses.body();
        }

        throw new Exception( courses.errorBody().toString() );
    }

    public interface UdacityCoursesCallback {
        void onData( UdacityCourses courses );
        void onDataError( String error);
        void onFailure( Throwable throwable);
    }

}
