package com.sammy.datasource

import retrofit2.Retrofit

class NetworkClient<T>(val retrofit: Retrofit){

    fun getRetrofitService(interfaceTyoe : Class<T>) : T {
        return retrofit.create(interfaceTyoe)
    }
}