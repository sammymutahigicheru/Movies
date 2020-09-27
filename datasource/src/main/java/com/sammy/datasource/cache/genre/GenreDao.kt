package com.sammy.datasource.cache.genre

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GenreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(genres: List<Genre>)

    @Query("SELECT * FROM genre")
    fun load(): LiveData<List<Genre>>
}