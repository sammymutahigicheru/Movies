package com.sammy.datasource.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sammy.datasource.cache.genre.GenreDao
import com.sammy.datasource.cache.movies.MovieDao

@Database(entities = [], version = 1)
abstract class MainDatabase : RoomDatabase() {


    abstract fun genreDao(): GenreDao

    abstract fun movieDao(): MovieDao


    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "MainDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}