package com.sammy.movies.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.network.cache.Listener
import com.sammy.datasource.cache.genre.GenreResponse
import com.sammy.datasource.cache.movies.MoviesResponse
import com.sammy.datasource.datasource.GenreDataSource
import com.sammy.datasource.datasource.MovieDataSource
import javax.inject.Inject

class MoviesViewModel @Inject constructor(val dataSource: MovieDataSource,val genreDataSource:GenreDataSource):ViewModel(){
    var moviesLiveData : MutableLiveData<MoviesResponse> = MutableLiveData()
    var genreLiveData : MutableLiveData<GenreResponse> = MutableLiveData()
    fun getMovies(page:Int,sortBy:String): LiveData<MoviesResponse> {

        return dataSource.getMovies(page,sortBy,object :
            Listener<MoviesResponse> {
            override fun onResponse(response: MoviesResponse) {
                moviesLiveData.postValue(response)
            }
        })

    }
    fun getGenre(): LiveData<GenreResponse> {
        return genreDataSource.getGenres(object :
            Listener<GenreResponse> {
            override fun onResponse(response: GenreResponse) {
                genreLiveData.postValue(response)
            }
        })

    }
}