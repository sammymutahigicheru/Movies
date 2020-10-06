package com.sammy.datasource.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import com.app.network.cache.Listener
import com.sammy.datasource.NetworkClient
import com.sammy.datasource.api.MoviesApi
import com.sammy.datasource.cache.trailer.TrailerPersist
import com.sammy.datasource.cache.trailer.TrailerResponse
import com.sammy.datasource.utils.API_KEY
import com.sammy.datasource.utils.LANGUAGE
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class TrailerDatasource @Inject constructor(
    private val networkClient: NetworkClient<MoviesApi>,
    val trailerPersist: TrailerPersist
) {
    fun getGenres(id:Int,listener: Listener<TrailerResponse>): LiveData<TrailerResponse> {
        networkClient.getRetrofitService(MoviesApi::class.java).getTrailers(id,API_KEY, LANGUAGE)
            .enqueue(object : Callback<TrailerResponse> {
                override fun onFailure(call: Call<TrailerResponse>, t: Throwable) {
                    Log.d("response_posts", t.message!!)
                }

                override fun onResponse(
                    call: Call<TrailerResponse>,
                    response: Response<TrailerResponse>
                ) {
                    response.body()?.let {
                        listener.onResponse(response = it)
                        GlobalScope.launch {
                            trailerPersist.save(it)
                        }
                    }
                }
            })
        return trailerPersist.load()
    }
}