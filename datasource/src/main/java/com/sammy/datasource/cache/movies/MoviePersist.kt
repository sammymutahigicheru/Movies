package com.sammy.datasource.cache.movies

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.app.network.cache.CacheInterface
import com.sammy.datasource.cache.MainDatabase
import com.sammy.datasource.cache.genre.Genre
import com.sammy.datasource.cache.genre.GenreDao
import javax.inject.Inject

class MoviePersist @Inject constructor(val context: Context) :
    CacheInterface<Movie> {

    private var movieDao: MovieDao = MainDatabase.getDatabase(context).movieDao()

    @WorkerThread
    override suspend fun save(items: List<Movie>) {
        movieDao.save(items)
    }

    override  fun load(): LiveData<List<Movie>> {
        return movieDao.load()
    }

}