package eu.caraus.dynamo.application.data.remote.udacity;

import java.util.List;

import eu.caraus.dynamo.application.data.domain.udacity.CoursesItem;
import io.reactivex.Single;
import retrofit2.http.GET;


public interface UdacityCoursesApi {

    @GET("/public-api/v1/courses/")
    Single<List<CoursesItem>> getCoursesItemList();

    @GET("/public-api/v1/courses/")
    List<CoursesItem> getCoursesItemAsList();

}
