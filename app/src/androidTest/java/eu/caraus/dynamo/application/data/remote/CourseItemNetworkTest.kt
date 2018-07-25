package eu.caraus.dynamo.application.data.remote

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import eu.caraus.dynamo.application.common.schedulers.TestSchedulerProvider
import eu.caraus.dynamo.application.data.local.Database
import eu.caraus.dynamo.application.data.remote.udacity.UdacityCoursesService
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CourseItemDatabaseTest {

    private val service  = UdacityCoursesService()

    private val database : Database = Room.inMemoryDatabaseBuilder (
                                                InstrumentationRegistry.getTargetContext() ,
                                                Database::class.java
                                                //Database.DATABASE_NAME
                                          )
                                          .fallbackToDestructiveMigration()
                                          .build()

    private val scheduler = TestSchedulerProvider()

    @Before
    fun setup(){

    }

    @Test
    fun simpleTestNetwork(){

        service.get().coursesItemList.test().run {

            val list = values()[0]

            assertNotZero( list.size )

            list.forEach {

                if( list.indexOf(it) == 61) {

                    // Check Key
                    assertThat( it.key , `is`("ud977"))

                    // Check Affiliates
                    assertThat( it.affiliates!![0].key, `is`( "5448383925583872"))
                    assertThat( it.affiliates!![0].name, `is`("Alteryx"))
                    assertThat( it.affiliates!![0].image, `is`("https://s3-us-west-1.amazonaws.com/udacity-content/partner/logo-color-alteryx-9aac6df.svg"))

                    // Check Instructors
                    assertThat( it.instructors!![0].key,`is`( "maureen-wolfson"))
                    assertThat( it.instructors!![0].name,`is`( "Maureen Wolfson"))
                    assertThat( it.instructors!![0].image,`is`("https://s3-us-west-1.amazonaws.com/udacity-content/instructor/maureen-wolfson%402x-9c8500a.jpg"))
                    assertThat( it.instructors!![0].title,`is`("Instructor"))

                    // Check flags

                    assertThat( it.flags?.isCapped, `is`(false))
                    assertThat( it.flags?.isAvailable, `is`(true))
                    assertThat( it.flags?.isPublicListing, `is`(true))

                    // Check tracks

                    assertThat( it.tracks!![0], `is`("All"))
                    assertThat( it.tracks!![1], `is`("Data Science"))
                    assertThat( it.tracks!![2], `is`("Data Analytics"))

                    // Check projects
                    assertThat( it.projects!![0].key,`is`("7705071773"))
                    assertThat( it.projects!![0].name,`is`("Select the Location of a New Pet Store"))

                    // Check related degree
                    assertThat( it.relatedDegreeKeys!![0], `is`("nd008"))

                }
            }

        }

    }

    @Test
    fun simpleTestNetworkAndDatabase(){

        service.get().coursesItemList.test().run {

            val list = values()[0]

            assertNotZero( list.size )

            list.let {
                database.coursesItemDao().upsertAll( it )
            }

        }

        database.coursesItemDao().getAll().forEach {

            val list = it

            assertNotZero( list.size )

            val item = list[61]

            item.let {

                // Check Key
                assertThat( it.key , `is`("ud977"))

                // Check Affiliates
                assertThat( it.affiliates!![0].key, `is`( "5448383925583872"))
                assertThat( it.affiliates!![0].name, `is`("Alteryx"))
                assertThat( it.affiliates!![0].image, `is`("https://s3-us-west-1.amazonaws.com/udacity-content/partner/logo-color-alteryx-9aac6df.svg"))

                // Check Instructors
                assertThat( it.instructors!![0].key,`is`( "maureen-wolfson"))
                assertThat( it.instructors!![0].name,`is`( "Maureen Wolfson"))
                assertThat( it.instructors!![0].image,`is`("https://s3-us-west-1.amazonaws.com/udacity-content/instructor/maureen-wolfson%402x-9c8500a.jpg"))
                assertThat( it.instructors!![0].title,`is`("Instructor"))

                // Check flags

                assertThat( it.flags?.isCapped, `is`(false))
                assertThat( it.flags?.isAvailable, `is`(true))
                assertThat( it.flags?.isPublicListing, `is`(true))

                // Check tracks

                assertThat( it.tracks!![0], `is`("All"))
                assertThat( it.tracks!![1], `is`("Data Science"))
                assertThat( it.tracks!![1], `is`("Data Analytics"))

                // Check projects
                assertThat( it.projects!![0].key,`is`("7705071773"))
                assertThat( it.projects!![0].name,`is`("7Select the Location of a New Pet Store"))

                // Check related degree
                assertThat( it.relatedDegreeKeys!![0], `is`("nd008"))


            }

        }

    }

    @Test
    fun simpleTest() {

        service.get().coursesItemList.test().run {
            assertNotZero( values()[0].size )
        }

    }

    fun assertNotZero( value : Int ){
        assertThat( value , `is`( not(0)))
    }

    fun log( msg : String ){
        Log.d("TEST",msg)
    }

}