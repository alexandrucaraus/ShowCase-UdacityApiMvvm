package eu.caraus.dynamo.application.data.local.udacity.converters

import android.arch.persistence.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import eu.caraus.dynamo.application.data.domain.udacity.Flags

class FlagsTypeConverter {

    @TypeConverter
    fun toFlags(  flagsAsString : String? ) : Flags {

        if( flagsAsString == null){
            Flags(0,false,false,false,false,false,false)
        }

        return Gson().fromJson<Flags>( flagsAsString!! )
    }

    @TypeConverter
    fun fromFlags( flags : Flags ) : String? {

        return Gson().toJson( flags )
    }

    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)

}