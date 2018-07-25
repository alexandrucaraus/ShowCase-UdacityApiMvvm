package eu.caraus.dynamo.application.data.domain.udacity


import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName
import eu.caraus.dynamo.application.data.local.udacity.converters.TranscodingsTypeConverter
import io.reactivex.annotations.NonNull

import java.io.Serializable

@Entity(

        tableName = "teaser_video",

        indices = [ (Index("teaserId")) ],

        foreignKeys = [( ForeignKey(

                            entity = CoursesItem::class,

                            parentColumns = ["key"],

                            childColumns  = ["teaserId"],

                            onDelete      = ForeignKey.CASCADE )

                       )]

)
data class TeaserVideo  (

    @NonNull
    @PrimaryKey( autoGenerate = true )
    var teaserId : Int,

    @SerializedName("vimeo_id")
    var vimeoId: String? = null,

    @SerializedName("youtube_url")
    var youtubeUrl: String? = null,

    @SerializedName("transcodings")
    @TypeConverters( TranscodingsTypeConverter::class)
    var transcodings: Transcodings? = null

) : Serializable {
    constructor() : this(0,"","",null)
}