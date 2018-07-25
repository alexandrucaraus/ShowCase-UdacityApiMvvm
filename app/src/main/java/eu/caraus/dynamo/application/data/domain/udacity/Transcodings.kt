package eu.caraus.dynamo.application.data.domain.udacity


import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName

import java.io.Serializable

@Entity(

        tableName = "transcodings",

        indices = [ (Index("transcodingId")) ],

        foreignKeys = [( ForeignKey (

                        entity        = CoursesItem::class,

                        parentColumns = ["key"],

                        childColumns  = ["transcodingId"],

                        onDelete = ForeignKey.CASCADE)

                       )]

)
data class Transcodings (

    @PrimaryKey( autoGenerate = true)
    var transcodingId : Int,

    @SerializedName("480p_1000kbps_mp4")
    var jsonMember480p1000kbpsMp4: String? = null,

    @SerializedName("720p_mp4")
    var jsonMember720pMp4: String? = null,

    @SerializedName("480p_ogg")
    var jsonMember480pOgg: String? = null,

    @SerializedName("480p_mp4")
    var jsonMember480pMp4: String? = null

) : Serializable