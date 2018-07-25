package eu.caraus.dynamo.application.data.local.udacity.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import eu.caraus.dynamo.application.data.domain.udacity.Transcodings
import io.reactivex.Flowable

@Dao
interface TranscodingsDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    fun upsertAll( items : Transcodings )

    @Query("SELECT * FROM transcodings")
    fun getAll() : Flowable<List<Transcodings>>

}