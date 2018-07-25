package eu.caraus.dynamo.application.data.local.udacity.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import eu.caraus.dynamo.application.data.domain.udacity.CoursesItem
import io.reactivex.Flowable

@Dao
interface CoursesItemDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    fun upsertAll( coursesItems : List<CoursesItem>)

    @Query( "select * from courses_item" )
    fun getAll() : Flowable<List<CoursesItem>>

}
