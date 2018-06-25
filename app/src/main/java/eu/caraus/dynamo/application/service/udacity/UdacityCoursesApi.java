package eu.caraus.dynamo.application.service.udacity;

import eu.caraus.dynamo.application.domain.udacity.UdacityCourses;
import retrofit2.Call;
import retrofit2.http.GET;


public interface UdacityCoursesApi {

    @GET("/public-api/v1/courses/")
    Call<UdacityCourses> getUdacityCoursesList();

}
