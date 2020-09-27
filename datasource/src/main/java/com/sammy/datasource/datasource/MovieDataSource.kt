package com.sammy.datasource.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import com.app.network.cache.Listener
import com.sammy.datasource.NetworkClient
import com.sammy.datasource.api.MoviesApi
import com.sammy.datasource.cache.movies.Movie
import com.sammy.datasource.cache.movies.MoviePersist
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


    fun getMovies(listener: Listener<List<Movie>>): LiveData<List<Movie>> {

        return moviePersist.load()

    }

}