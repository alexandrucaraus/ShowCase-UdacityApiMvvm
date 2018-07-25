package eu.caraus.dynamo.application.data.local.udacity.converters

import android.arch.persistence.room.TypeConverter
import com.google.common.reflect.TypeToken
import com.google.gson.Gson
import eu.caraus.dynamo.application.data.domain.udacity.AffiliatesItem

class AffiliatesItemListTypeConverter {

    @TypeConverter
    fun toAffiliatesList(  affiliatesListAsString : String? ) :  List<AffiliatesItem> {

        if( affiliatesListAsString == null){
            emptyList<List<AffiliatesItem>>()
        }

        return Gson().fromJson<List<AffiliatesItem>>( affiliatesListAsString!! )
    }

    @TypeConverter
    fun fromAffiliatesList( affiliatesList : List<AffiliatesItem> ) : String? {

        return Gson().toJson( affiliatesList )
    }

    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)

}