package eu.caraus.dynamo.application.data.local.udacity.converters

import android.arch.persistence.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import eu.caraus.dynamo.application.data.domain.udacity.Transcodings

class TranscodingsTypeConverter {

    @TypeConverter
    fun toTranscodings(  transcodings : String? ) : Transcodings {

        if( transcodings == null){
            Transcodings(0,"","","","")
        }

        return Gson().fromJson<Transcodings>( transcodings!! )
    }

    @TypeConverter
    fun fromTranscodings( transcodings : Transcodings ) : String? {

        return Gson().toJson( transcodings )
    }

    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)

}