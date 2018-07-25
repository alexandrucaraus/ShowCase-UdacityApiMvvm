package eu.caraus.dynamo.application.data.domain.udacity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(

        tableName = "projects",

        indices = [ (Index("key")) ],

        foreignKeys = [(ForeignKey(

                entity = CoursesItem::class,

                parentColumns = ["key"],

                childColumns = ["key"],

                onDelete = ForeignKey.CASCADE))]


)
data class Projects(

        @SerializedName("key")
        var key: String? = null,

        @SerializedName("name")
        var name : String? = null,

        @SerializedName("description")
        var description : String? = null


) : Serializable