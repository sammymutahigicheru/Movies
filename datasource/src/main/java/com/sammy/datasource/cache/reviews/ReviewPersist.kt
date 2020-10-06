package com.sammy.datasource.cache.reviews

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.app.network.cache.CacheInterface
import com.sammy.datasource.cache.MainDatabase
import com.sammy.datasource.cache.trailer.TrailerDao
import com.sammy.datasource.cache.trailer.TrailerResponse
import javax.inject.Inject

class ReviewPersist @Inject constructor(context: Context) :
    CacheInterface<ReviewResponse> {

    private var reviewDao: ReviewDao = MainDatabase.getDatabase(context).reviewDao()

    @WorkerThread
    override suspend fun save(items: ReviewResponse) {
        reviewDao.save(items)
    }

    override  fun load(): LiveData<ReviewResponse> {
        return reviewDao.load()
    }

}