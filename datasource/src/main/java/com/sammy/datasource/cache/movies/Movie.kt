package com.sammy.datasource.cache.movies

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sammy.datasource.cache.genre.Genre
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id") @Expose
    var id: Int,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String,

    @SerializedName("release_date")
    @Expose
    val releaseDate: String,

    @SerializedName("vote_average")
    @Expose
    val rating:Float,

    @SerializedName("genre_ids")
    @Expose
    val genreIds: List<Int>,

    @SerializedName("overview")
    @Expose
    val overview: String,

    @SerializedName("genres")
    @Expose
    val genres: List<Genre>,

    @SerializedName("backdrop_path")
    @Expose
    val backdrop: String
): Parcelable