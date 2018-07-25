package eu.caraus.dynamo.application.data.local.udacity.converters

import android.arch.persistence.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import eu.caraus.dynamo.application.data.domain.udacity.TeaserVideo

class TeaserVideoTypeConverter {

    @TypeConverter
    fun to(  teaserVideoListAsString : String? ) : TeaserVideo {

        if( teaserVideoListAsString == null){
            TeaserVideo(0,"","",null)
        }

        return Gson().fromJson<TeaserVideo>( teaserVideoListAsString!! )
    }

    @TypeConverter
    fun from( teaserVideo : TeaserVideo ) : String? {

        return Gson().toJson( teaserVideo )
    }

    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)


}