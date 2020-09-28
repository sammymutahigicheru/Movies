package com.sammy.datasource.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import com.app.network.cache.Listener
import com.sammy.datasource.NetworkClient
import com.sammy.datasource.api.MoviesApi
import com.sammy.datasource.cache.movies.Movie
import com.sammy.datasource.cache.movies.MoviePersist
import com.sammy.datasource.cache.movies.MoviesResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieDataSource @Inject constructor(
    private val networkClient: NetworkClient<MoviesApi>,
    val moviePersist: MoviePersist
) {


    fun getMovies(listener: Listener<MoviesResponse>): LiveData<MoviesResponse> {

        networkClient.getRetrofitService(MoviesApi::class.java).getPopularMovies("", "", 0)
            .enqueue(object : Callback<MoviesResponse> {
                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    Log.d("response_posts", t.message!!)
                }

                override fun onResponse(
                    call: Call<MoviesResponse>,
                    response: Response<MoviesResponse>
                ) {
                    response.body()?.let {
                        listener.onResponse(response = it)
                        GlobalScope.launch {
                            moviePersist.save(it)
                        }
                    }
                }
            })
        return moviePersist.load()
    }
}