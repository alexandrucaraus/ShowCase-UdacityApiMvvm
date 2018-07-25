package eu.caraus.dynamo.application.data.local.udacity.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import eu.caraus.dynamo.application.data.domain.udacity.AffiliatesItem
import io.reactivex.Flowable

@Dao
interface AffiliatesItemDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    fun upsertAll( items: List<AffiliatesItem> )

    @Query("SELECT * FROM affiliates_item")
    fun getAll() : Flowable<List<AffiliatesItem>>

}