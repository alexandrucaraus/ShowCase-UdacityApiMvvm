package eu.caraus.dynamo.application.data.remote.udacity.gson

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import com.google.gson.reflect.TypeToken

import java.lang.reflect.Type

import java.util.ArrayList

import eu.caraus.dynamo.application.data.domain.udacity.CoursesItem
import eu.caraus.dynamo.application.data.domain.udacity.Projects
import eu.caraus.dynamo.application.data.domain.udacity.TeaserVideo


class CourseListDeserializer : JsonDeserializer<List<CoursesItem>> {

    var items: MutableList<CoursesItem> = ArrayList()

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement,
                             typeOfT: Type,
                             context: JsonDeserializationContext): List<CoursesItem> {

        val element = json.asJsonObject.get("courses")

        val projectsJsonDeserializer = ProjectsJsonDeserializer()

        val courseListDeserializer = CourseListDeserializer()

        val teaserVideoJsonDeserializer = TeaserVideoDeserializer()

        val gsonBuilder = GsonBuilder().setLenient()
        gsonBuilder.registerTypeAdapter(Projects::class.java, projectsJsonDeserializer)
        gsonBuilder.registerTypeAdapter(TeaserVideo::class.java, teaserVideoJsonDeserializer)
        gsonBuilder.registerTypeAdapter(object : TypeToken<List<CoursesItem>>() {

        }.type, courseListDeserializer)
        val gson = gsonBuilder.create()

        for (i in 0 until element.asJsonArray.size()) {
            val `object` = element.asJsonArray.get(i) as JsonObject
            val item = gson.fromJson(`object`, CoursesItem::class.java)
            items.add(item)
        }

        return items
    }
}
