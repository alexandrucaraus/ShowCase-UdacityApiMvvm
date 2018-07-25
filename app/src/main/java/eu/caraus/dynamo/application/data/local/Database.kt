package eu.caraus.dynamo.application.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import eu.caraus.dynamo.application.data.local.udacity.converters.*
import eu.caraus.dynamo.application.data.local.udacity.dao.*
import eu.caraus.dynamo.application.data.domain.udacity.*

@Database(
            entities = [

                            (CoursesItem::class),
                            (Flags::class),
                            (InstructorsItem::class),
                            (AffiliatesItem::class),
                            (TeaserVideo::class),
                            (Transcodings::class)

            ],

            version = 3,

            exportSchema = false

)
@TypeConverters(
        ( AffiliatesItemListTypeConverter::class ),
        ( InstructorsListTypeConverter::class),
        ( FlagsTypeConverter::class ),
        ( TeaserVideoTypeConverter::class),
        ( TranscodingsTypeConverter::class ),
        ( ProjectsListTypeConverter::class),
        ( StringListTypeConverter::class)

)
abstract class Database : RoomDatabase() {

    companion object {

        const val DATABASE_NAME = "udacity_courses_db"

    }

    abstract fun coursesItemDao() : CoursesItemDao

    abstract fun affiliatesItemDao() : AffiliatesItemDao

    abstract fun flagsDao() : FlagsDao

    abstract fun instructorsItemDao() : InstructorsItemDao

    abstract fun teaserVideoDao() : TeaserVideoDao

    abstract fun transcodingsDao() : TranscodingsDao

}