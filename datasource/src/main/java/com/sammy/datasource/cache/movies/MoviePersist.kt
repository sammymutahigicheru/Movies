package com.sammy.datasource.cache.movies

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.app.network.cache.CacheInterface
import com.sammy.datasource.cache.MainDatabase
import javax.inject.Inject

class MoviePersist @Inject constructor(context: Context) :
    CacheInterface<MoviesResponse> {

    private var movieDao: MovieDao = MainDatabase.getDatabase(context).movieDao()

    @WorkerThread
    override suspend fun save(items: MoviesResponse) {
        movieDao.save(items)
    }

    override  fun load(): LiveData<MoviesResponse> {
        return movieDao.load()
    }

}