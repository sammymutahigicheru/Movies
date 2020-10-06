package com.sammy.datasource.cache.reviews

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sammy.datasource.cache.trailer.TrailerResponse

@Dao
interface ReviewDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(trailer: TrailerResponse)

    @Query("SELECT * FROM trailerresponse")
    fun load(): LiveData<TrailerResponse>
}