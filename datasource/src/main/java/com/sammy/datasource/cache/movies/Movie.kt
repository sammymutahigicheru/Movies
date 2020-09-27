package com.sammy.datasource.cache.movies

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sammy.datasource.cache.genre.Genre

data class Movie(
    @SerializedName("id") @Expose
    private var id: Int = 0,
    @SerializedName("title")
    @Expose
    private val title: String? = null,

    @SerializedName("poster_path")
    @Expose
    private val posterPath: String? = null,

    @SerializedName("release_date")
    @Expose
    private val releaseDate: String? = null,

    @SerializedName("vote_average")
    @Expose
    private val rating: Float = 0f,

    @SerializedName("genre_ids")
    @Expose
    private val genreIds: List<Int>? = null,

    @SerializedName("overview")
    @Expose
    private val overview: String? = null,

    @SerializedName("genres")
    @Expose
    private val genres: List<Genre>? = null,

    @SerializedName("backdrop_path")
    @Expose
    private val backdrop: String? = null
)