package com.sammy.datasource.cache.movies

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(genres: List<Movie>)

    @Query("SELECT * FROM movie")
    fun load(): LiveData<List<Movie>>
}