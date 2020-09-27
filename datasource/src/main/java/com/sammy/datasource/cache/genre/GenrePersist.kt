package com.sammy.datasource.cache.genre

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.app.network.cache.CacheInterface
import com.sammy.datasource.cache.MainDatabase
import javax.inject.Inject

class GenrePersist @Inject constructor(val context: Context) :
    CacheInterface<Genre> {

    private var genreDao: GenreDao = MainDatabase.getDatabase(context).genreDao()

    @WorkerThread
    override suspend fun save(items: List<Genre>) {
        genreDao.save(items)
    }

    override  fun load(): LiveData<List<Genre>> {
        return genreDao.load()
    }

}