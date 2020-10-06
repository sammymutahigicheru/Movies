package com.sammy.datasource.cache.movies

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.sammy.datasource.cache.genre.Genre
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id") @Expose
    var id: Int?=null,

    @SerializedName("title")
    @Expose
    val title: String?=null,

    @SerializedName("poster_path")
    @Expose
    val posterPath: String?=null,

    @SerializedName("release_date")
    @Expose
    val releaseDate: String?=null,

    @SerializedName("vote_average")
    @Expose
    val rating:Float?=null,

    @SerializedName("genre_ids")
    @Expose
    val genreIds: List<Int>,

    @SerializedName("overview")
    @Expose
    val overview: String?=null,

    @SerializedName("genres")
    @Expose
    val genres: List<Genre>?=null,

    @SerializedName("backdrop_path")
    @Expose
    val backdrop: String?=null
): Parcelable