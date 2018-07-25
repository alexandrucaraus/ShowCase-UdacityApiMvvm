package eu.caraus.dynamo.application.data.domain.udacity

import android.arch.persistence.room.*
import java.io.Serializable

import com.google.gson.annotations.SerializedName
import eu.caraus.dynamo.application.data.local.udacity.converters.*
import io.reactivex.annotations.NonNull

@Entity( tableName = "courses_item", indices = [ (Index("key")) ] )
data class CoursesItem  (

    @NonNull
    @PrimaryKey
    @SerializedName("key")
    var key: String,

    @SerializedName("syllabus")
    var syllabus: String? = null,

    @SerializedName("featured")
    var isFeatured: Boolean = false,

    @SerializedName("expected_duration_low")
    var expectedDurationLow: String? = null,

    @SerializedName("capped")
    var isCapped: Boolean = false,

    @SerializedName("available")
    var isAvailable: Boolean = false,

    @SerializedName("public_listing")
    var isPublicListing: Boolean = false,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("project_name")
    var projectName: String? = null,

    @SerializedName("faq")
    var faq: String? = null,

    @SerializedName("expected_duration")
    var expectedDuration: String? = null,

    @SerializedName("expected_duration_unit")
    var expectedDurationUnit: String? = null,

    @SerializedName("required_knowledge")
    var requiredKnowledge: String? = null,

    @SerializedName("banner_image")
    var bannerImage: String? = null,

    @SerializedName("short_summary")
    var shortSummary: String? = null,

    @SerializedName("slug")
    var slug: String? = null,

    @SerializedName("summary")
    var summary: String? = null,

    @SerializedName("enables_profiles")
    var isEnablesProfiles: Boolean = false,

    @SerializedName("image")
    var image: String? = null,

    @SerializedName("starter")
    var isStarter: Boolean = false,

    @SerializedName("level")
    var level: String? = null,

    @SerializedName("open_for_enrollment")
    var isOpenForEnrollment: Boolean = false,

    @SerializedName("expected_duration_high")
    var expectedDurationHigh: String? = null,

    @SerializedName("full_course_available")
    var isFullCourseAvailable: Boolean = false,

    @SerializedName("project_description")
    var projectDescription: String? = null,

    @SerializedName("new_release")
    var isNewRelease: Boolean = false,

    @SerializedName("expected_learning")
    var expectedLearning: String? = null,

    @SerializedName("subtitle")
    var subtitle: String? = null,

    @SerializedName("affiliates")
    @TypeConverters( AffiliatesItemListTypeConverter::class )
    var affiliates: List<AffiliatesItem>? = null,

    @SerializedName("instructors")
    @TypeConverters( InstructorsListTypeConverter::class )
    var instructors: List<InstructorsItem>? = null,

    @SerializedName("flags")
    @TypeConverters( FlagsTypeConverter::class )
    var flags: Flags? = null,

    @SerializedName("teaser_video")
    @TypeConverters( TeaserVideoTypeConverter::class )
    var teaserVideo: TeaserVideo? = null,

    @SerializedName("projects")
    @TypeConverters( ProjectsListTypeConverter::class )
    var projects: List<Projects>? = null,

    @SerializedName("student_groups")
    @TypeConverters( StringListTypeConverter::class )
    var studentGroups: List<String>? = null,

    @SerializedName("related_degree_keys")
    @TypeConverters( StringListTypeConverter::class )
    var relatedDegreeKeys: List<String>? = null,

    @SerializedName("tracks")
    @TypeConverters( StringListTypeConverter::class)
    var tracks: List<String>? = null,

    @SerializedName("assistants")
    @TypeConverters( StringListTypeConverter::class )
    var assistants: List<String>? = null,

    @SerializedName("graduate_groups")
    @TypeConverters( StringListTypeConverter::class )
    var graduateGroups: List<String>? = null,

    @SerializedName("tags")
    @TypeConverters( StringListTypeConverter::class )
    var tags: List<String>? = null


) : Serializable {
    constructor() : this(
               "",
            "",
                  false,
            "",
            false,
                false,
            false,"",null,"","","",null,
"","","","",false,"",false,
            "",false,"",false,"",false,"","",null,null,
            null,null,null,null,null,null,null,null,null
            )
}