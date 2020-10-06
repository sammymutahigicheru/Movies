package com.sammy.datasource.cache.trailer

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.app.network.cache.CacheInterface
import com.sammy.datasource.cache.MainDatabase
import com.sammy.datasource.cache.movies.MovieDao
import com.sammy.datasource.cache.movies.MoviesResponse
import javax.inject.Inject

class TrailerPersist @Inject constructor(context: Context) :
    CacheInterface<TrailerResponse> {

    private var trailerDao: TrailerDao = MainDatabase.getDatabase(context).trailerDao()

    @WorkerThread
    override suspend fun save(items: TrailerResponse) {
        trailerDao.save(items)
    }

    override  fun load(): LiveData<TrailerResponse> {
        return trailerDao.load()
    }

}