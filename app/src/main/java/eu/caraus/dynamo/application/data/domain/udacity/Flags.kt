package eu.caraus.dynamo.application.data.domain.udacity


import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

import java.io.Serializable

@Entity(

        tableName   = "flags",

        indices     = [ ( Index("flagId") ) ],

        foreignKeys = [ ( ForeignKey(
                            entity        = CoursesItem::class,
                            parentColumns = ["key"],
                            childColumns  = ["flagId"],
                            onDelete = ForeignKey.CASCADE )
                      ) ]

)
data class Flags  (

    @PrimaryKey( autoGenerate = true )
    var flagId : Int,

    @SerializedName("enables_profiles")
    var isEnablesProfiles: Boolean = false,

    @SerializedName("featured")
    var isFeatured: Boolean = false,

    @SerializedName("starter")
    var isStarter: Boolean = false,

    @SerializedName("capped")
    var isCapped: Boolean = false,

    @SerializedName("new_release")
    var isNewRelease: Boolean = false,

    @SerializedName("available")
    var isAvailable: Boolean = false,

    @SerializedName("open_for_enrollment")
    var isOpenForEnrollment: Boolean = false,

    @SerializedName("public_listing")
    var isPublicListing: Boolean = false,

    @SerializedName("full_course_available")
    var isFullCourseAvailable: Boolean = false

) : Serializable