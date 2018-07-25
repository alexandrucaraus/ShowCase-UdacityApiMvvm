package eu.caraus.dynamo.application.data.local.udacity.converters

import android.arch.persistence.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import eu.caraus.dynamo.application.data.domain.udacity.Projects

class ProjectsListTypeConverter {

    @TypeConverter
    fun to(  projectsListAsString : String? ) :  List<Projects> {

        if( projectsListAsString == null){
            emptyList< List<Projects> >()
        }

        return Gson().fromJson<List<Projects>>( projectsListAsString!! )
    }

    @TypeConverter
    fun from( affiliatesList : List<Projects> ) : String? {

        return Gson().toJson( affiliatesList )
    }

    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)

}