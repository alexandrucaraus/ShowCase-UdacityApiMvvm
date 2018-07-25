package eu.caraus.dynamo.application.data.remote.udacity.gson

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import eu.caraus.dynamo.application.data.domain.udacity.Projects
import java.lang.reflect.Type

class ProjectsJsonDeserializer : JsonDeserializer<Projects> {

    override fun deserialize( json: JsonElement?,
                              typeOfT: Type?,
                              context: JsonDeserializationContext?): Projects {

        val jsonObject = json?.asJsonObject

        return Projects(
                jsonObject?.get("key")?.asString,
                jsonObject?.get("name")?.asString,
                jsonObject?.get("description")?.asString
            )
    }

}