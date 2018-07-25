package eu.caraus.dynamo.application.data.local.udacity.converters

import android.arch.persistence.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import eu.caraus.dynamo.application.data.domain.udacity.AffiliatesItem
import eu.caraus.dynamo.application.data.domain.udacity.InstructorsItem

class InstructorsListTypeConverter {

    @TypeConverter
    fun toAffiliatesList(  instructorsListAsString : String? ) :  List<InstructorsItem> {

        if( instructorsListAsString == null){
            emptyList<List<AffiliatesItem>>()
        }

        return Gson().fromJson<List<InstructorsItem>>( instructorsListAsString!! )
    }

    @TypeConverter
    fun fromAffiliatesList( affiliatesList : List<InstructorsItem> ) : String? {

        return Gson().toJson( affiliatesList )
    }

    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)

}