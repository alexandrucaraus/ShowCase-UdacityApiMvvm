package eu.caraus.dynamo.application.data.remote.udacity.gson

import com.google.gson.*

import eu.caraus.dynamo.application.data.domain.udacity.TeaserVideo
import eu.caraus.dynamo.application.data.domain.udacity.Transcodings

import java.lang.reflect.Type

class TeaserVideoDeserializer : JsonDeserializer<TeaserVideo> {

    override fun deserialize( json: JsonElement?,
                              typeOfT: Type?,
                              context: JsonDeserializationContext?): TeaserVideo {

        val gson = GsonBuilder().setLenient()
                                       .registerTypeAdapter( Transcodings::class.java,
                                                             TranscodingsJsonDeserializer())
                                       .create()

        val jsonObject = json?.asJsonObject

        val transcodings
                = gson.fromJson<Transcodings>( jsonObject?.get("transcodings"),
                                               Transcodings::class.java )

        return TeaserVideo(0,
                            jsonObject?.get("vimeo_id")?.asString,
                            jsonObject?.get("youtube_url")?.asString,
                            transcodings )
    }

}
