package eu.caraus.dynamo.application.data.remote.udacity;




public class UdacityCoursesService {

    public static final String  TAG = UdacityCoursesService.class.getSimpleName();

    private UdacityCoursesApi udacityCoursesApi;

    public UdacityCoursesService() {

        udacityCoursesApi = (new UdacityCoursesApiClient()).getClient().create(UdacityCoursesApi.class);

    }

    public UdacityCoursesApi get(){
        return udacityCoursesApi;
    }

}
