package com.sammy.movies.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.network.cache.Listener
import com.sammy.datasource.cache.genre.GenreResponse
import com.sammy.datasource.cache.reviews.ReviewResponse
import com.sammy.datasource.cache.trailer.TrailerResponse
import com.sammy.datasource.datasource.GenreDataSource
import com.sammy.datasource.datasource.ReviewDatasource
import com.sammy.datasource.datasource.TrailerDatasource
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(
    val genreDataSource: GenreDataSource,
    val reviewDatasource: ReviewDatasource, val trailerDatasource: TrailerDatasource
):ViewModel() {
    var genreLiveData: MutableLiveData<GenreResponse> = MutableLiveData()
    var trailerLiveData: MutableLiveData<TrailerResponse> = MutableLiveData()
    var reviewLiveData: MutableLiveData<ReviewResponse> = MutableLiveData()

    fun getGenre(): LiveData<GenreResponse> {
        return genreDataSource.getGenres(object :
            Listener<GenreResponse> {
            override fun onResponse(response: GenreResponse) {
                genreLiveData.postValue(response)
            }
        })

    }

    fun getTrailers(id: Int): LiveData<TrailerResponse> {
        return trailerDatasource.getTrailers(id, object : Listener<TrailerResponse> {
            override fun onResponse(response: TrailerResponse) {
                trailerLiveData.postValue(response)
            }

        })
    }

    fun getReviews(id: Int): LiveData<ReviewResponse> {
        return reviewDatasource.getReviews(id, object : Listener<ReviewResponse> {
            override fun onResponse(response: ReviewResponse) {
                reviewLiveData.postValue(response)
            }

        })
    }
}