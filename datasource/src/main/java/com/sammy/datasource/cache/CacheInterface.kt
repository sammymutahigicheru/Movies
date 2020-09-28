package com.app.network.cache

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData


interface CacheInterface<V> {


    @WorkerThread
    suspend fun  save(items : V)

     fun  load() : LiveData<V>

}