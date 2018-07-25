package eu.caraus.dynamo.application.data.domain.udacity


import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull

import java.io.Serializable

@Entity(

        tableName   = "affiliates_item",

        indices     = [( Index("key") )],

        foreignKeys = [( ForeignKey( entity = CoursesItem::class,
                                     parentColumns = ["key"],
                                     childColumns = ["key"],
                                     onDelete = ForeignKey.CASCADE )
                      )]
)
data class AffiliatesItem  (

   @NonNull
   @PrimaryKey
   @SerializedName("key")
   var key: String,

   @SerializedName("name")
   var name: String? = null,

   @SerializedName("image")
   var image: String? = null

) : Serializable {
  // constructor() : this("" ,"" ,"" )
}