package com.sammy.datasource.cache.trailer

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TrailerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(trailer: TrailerResponse)

    @Query("SELECT * FROM trailerresponse")
    fun load(): LiveData<TrailerResponse>
}