package eu.caraus.dynamo.application.data.remote.udacity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import eu.caraus.dynamo.application.data.domain.udacity.CoursesItem;
import eu.caraus.dynamo.application.data.domain.udacity.Projects;
import eu.caraus.dynamo.application.data.domain.udacity.TeaserVideo;
import eu.caraus.dynamo.application.data.domain.udacity.Transcodings;
import eu.caraus.dynamo.application.data.remote.udacity.gson.CourseListDeserializer;
import eu.caraus.dynamo.application.data.remote.udacity.gson.ProjectsJsonDeserializer;
import eu.caraus.dynamo.application.data.remote.udacity.gson.TeaserVideoDeserializer;
import eu.caraus.dynamo.application.data.remote.udacity.gson.TranscodingsJsonDeserializer;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class UdacityCoursesApiClient {

    private final String BASE_URL = "https://www.udacity.com/";

    private Retrofit retrofit;

    public UdacityCoursesApiClient(){

        GsonBuilder gsonBuilder = new GsonBuilder().setLenient();
        gsonBuilder.registerTypeAdapter( Transcodings.class, new TranscodingsJsonDeserializer() );
        gsonBuilder.registerTypeAdapter( Projects.class, new ProjectsJsonDeserializer());
        gsonBuilder.registerTypeAdapter( new TypeToken<List<CoursesItem>>(){}.getType(), new CourseListDeserializer());
        gsonBuilder.registerTypeAdapter( TeaserVideo.class, new TeaserVideoDeserializer());
        Gson gson = gsonBuilder.create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory( GsonConverterFactory.create( gson))
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create())
                .client( client)
                .build();
    }

    public Retrofit getClient(){
        return retrofit;
    }

}
