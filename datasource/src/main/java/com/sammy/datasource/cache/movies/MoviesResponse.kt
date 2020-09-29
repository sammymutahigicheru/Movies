package com.sammy.datasource.cache.movies

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class MoviesResponse(
    @PrimaryKey
    @NonNull
    @SerializedName("page") @Expose
    var page: Int,

    @SerializedName("total_results")
    @Expose
    val totalResults: Int,

    @SerializedName("total_pages")
    @Expose
    val totalPages: Int,

    @SerializedName("results")
    @Expose
    val movies: List<Movie>


)