package eu.caraus.dynamo.application.data.remote.udacity.gson

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import eu.caraus.dynamo.application.data.domain.udacity.Transcodings
import java.lang.reflect.Type

class TranscodingsJsonDeserializer : JsonDeserializer<Transcodings> {

    override fun deserialize( json: JsonElement?,
                              typeOfT: Type?,
                              context: JsonDeserializationContext?): Transcodings {

        val jsonObject = json?.asJsonObject

        return Transcodings(0,
                                jsonObject?.get("480p_1000kbps_mp4").toString(),
                                jsonObject?.get("720p_mp4").toString(),
                                jsonObject?.get("480p_ogg").toString(),
                                jsonObject?.get("480p_mp4").toString()
                )

    }

}