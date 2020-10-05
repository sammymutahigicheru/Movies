package com.sammy.datasource.cache.genre

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.app.network.cache.ListCacheInterface
import com.sammy.datasource.cache.MainDatabase
import javax.inject.Inject

class GenrePersist @Inject constructor(context: Context) :
    ListCacheInterface<Genre> {

    private var genreDao: GenreDao = MainDatabase.getDatabase(context).genreDao()

    @WorkerThread
    override suspend fun save(items: List<Genre>) {
        genreDao.save(items)
    }

    override  fun load(): LiveData<List<Genre>> {
        return genreDao.load()
    }

}