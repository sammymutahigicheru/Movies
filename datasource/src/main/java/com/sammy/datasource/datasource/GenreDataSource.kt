package com.sammy.datasource.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import com.app.network.cache.Listener
import com.sammy.datasource.NetworkClient
import com.sammy.datasource.api.MoviesApi
import com.sammy.datasource.cache.genre.Genre
import com.sammy.datasource.cache.genre.GenrePersist
import com.sammy.datasource.cache.genre.GenreResponse
import com.sammy.datasource.utils.API_KEY
import com.sammy.datasource.utils.LANGUAGE
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GenreDataSource @Inject constructor(
    private val networkClient: NetworkClient<MoviesApi>,
    val genrePersist: GenrePersist
) {
    fun getGenres(listener: Listener<GenreResponse>):LiveData<GenreResponse>{
        networkClient.getRetrofitService(MoviesApi::class.java).getGenres(API_KEY, LANGUAGE)
            .enqueue(object : Callback<GenreResponse> {
                override fun onFailure(call: Call<GenreResponse>, t: Throwable) {
                    Log.d("response_posts", t.message!!)
                }

                override fun onResponse(
                    call: Call<GenreResponse>,
                    response: Response<GenreResponse>
                ) {
                    response.body()?.let {
                        listener.onResponse(response = it)
                        GlobalScope.launch {
                            genrePersist.save(it)
                        }
                    }
                }
            })
        return genrePersist.load()
    }
}