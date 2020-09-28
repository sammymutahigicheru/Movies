package com.sammy.datasource.cache.movies

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(movies: MoviesResponse)

    @Query("SELECT * FROM moviesresponse")
    fun load(): LiveData<MoviesResponse>
}