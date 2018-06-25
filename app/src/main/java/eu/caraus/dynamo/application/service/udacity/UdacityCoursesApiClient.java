package eu.caraus.dynamo.application.service.udacity;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UdacityCoursesApiClient {

    private final String BASE_URL = "https://www.udacity.com/";

    private Retrofit retrofit;

    public UdacityCoursesApiClient(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        //interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory( GsonConverterFactory.create(gson))
                .client( client)
                .build();
    }

    public Retrofit getClient(){
        return retrofit;
    }

}
