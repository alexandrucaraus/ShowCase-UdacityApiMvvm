package eu.caraus.dynamo.application.data.domain.udacity

import java.io.Serializable

import com.google.gson.annotations.SerializedName



data class UdacityCourses (

    @SerializedName("courses")
    var courses : List<CoursesItem>

) : Serializable