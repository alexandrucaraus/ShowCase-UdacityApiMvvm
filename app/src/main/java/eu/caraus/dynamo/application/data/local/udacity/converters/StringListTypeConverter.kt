package eu.caraus.dynamo.application.data.local.udacity.converters

import android.arch.persistence.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson

class StringListTypeConverter {

    @TypeConverter
    fun toStringList( stringList : String? ) : List<String> {

        if( stringList == null ){
            emptyList<List<String>>()
        }

        return Gson().fromJson<List<String>>( stringList!! )
    }

    @TypeConverter
    fun fromStringList( stringList : List<String> ) : String? {

        return Gson().toJson( stringList )
    }

    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)

}