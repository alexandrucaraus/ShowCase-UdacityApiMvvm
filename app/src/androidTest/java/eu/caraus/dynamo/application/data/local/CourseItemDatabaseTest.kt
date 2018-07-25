package eu.caraus.dynamo.application.data.local


import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import android.arch.persistence.room.Room

//import com.nhaarman.mockitokotlin2.doReturn
//import com.nhaarman.mockitokotlin2.mock

import eu.caraus.dynamo.application.data.domain.udacity.CoursesItem

import io.mockk.mockk
import org.junit.Assert.assertEquals

import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CourseItemDatabaseTest {

    private val database : Database = Room.inMemoryDatabaseBuilder (
            InstrumentationRegistry.getTargetContext() ,
            Database::class.java)
            .fallbackToDestructiveMigration()
            .build()

    @Before
    fun setup() {

    }

    @Test
    fun insert() {

        val item1 = mockk<CoursesItem>()
        val item2 = mockk<CoursesItem>()
        val item3 = mockk<CoursesItem>()
        val item4 = mockk<CoursesItem>()

        item1.key = "item1"
        item2.key = "item2"
        item3.key = "item3"
        item4.key = "item4"

        val listToInsert = listOf (
                item1 , item2 , item3 , item4
        )

        database.coursesItemDao().upsertAll( listToInsert )

        database.coursesItemDao().getAll().forEach {
            assertEquals( "item1", it[0].key )
            assertEquals( "item2", it[1].key )
            assertEquals( "item3", it[2].key )
            assertEquals( "item4", it[3].key )
        }

    }

    private fun log( msg : String ){
        System.out.println( msg )
    }

}
