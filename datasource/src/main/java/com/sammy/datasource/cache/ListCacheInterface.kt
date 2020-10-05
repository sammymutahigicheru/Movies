package com.app.network.cache

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData


interface ListCacheInterface<V> {


    @WorkerThread
    suspend fun  save(items : List<V>)

     fun  load() : LiveData<List<V>>

}