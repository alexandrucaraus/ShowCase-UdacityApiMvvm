package eu.caraus.dynamo.application.data.local.udacity.dao

import android.arch.persistence.room.*
import eu.caraus.dynamo.application.data.domain.udacity.TeaserVideo
import io.reactivex.Flowable

@Dao
interface TeaserVideoDao {

    @Insert( onConflict = OnConflictStrategy.REPLACE)
    fun upsertAll( item : TeaserVideo)

    @Query("SELECT * from teaser_video")
    fun getAll() : Flowable<TeaserVideo>

}