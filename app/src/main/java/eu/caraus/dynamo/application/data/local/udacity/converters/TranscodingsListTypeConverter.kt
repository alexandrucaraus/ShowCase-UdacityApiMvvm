package eu.caraus.dynamo.application.data.local.udacity.converters

import android.arch.persistence.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

import eu.caraus.dynamo.application.data.domain.udacity.Transcodings

class TranscodingsListTypeConverter {

    val gson = Gson()

    @TypeConverter
    fun toTranscodingsList( transcodingsListAsString : String? ) : List<Transcodings> {

        if( transcodingsListAsString == null ){
            return emptyList()
        }

        return gson.fromJson<List<Transcodings>>( transcodingsListAsString )
    }

    @TypeConverter
    fun fromTranscodingsList( transcodingsList : List<Transcodings> ) : String? {

        return gson.toJson(transcodingsList)
    }

    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)

}