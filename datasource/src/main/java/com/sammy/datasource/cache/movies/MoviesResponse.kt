package com.sammy.datasource.cache.movies

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sammy.datasource.cache.movies.Movie

data class MoviesResponse(
    @SerializedName("page") @Expose
    private var page: Int = 0,

    @SerializedName("total_results")
@Expose
private val totalResults:Int = 0,

    @SerializedName("results")
@Expose
private val movies: List<Movie>? = null,

    @SerializedName("total_pages")
@Expose
private val totalPages:Int = 0
)