package com.sammy.datasource.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sammy.datasource.cache.genre.Genre
import com.sammy.datasource.cache.movies.Movie
import com.sammy.datasource.cache.movies.MoviesResponse
import com.sammy.datasource.cache.reviews.Review
import com.sammy.datasource.cache.trailer.Trailer


class Converters {
    //movies
    @TypeConverter
    fun fromStringListMovie(value: String): List<Movie> {
        val type = object : TypeToken<List<Movie>>() {}.type
        return Gson().fromJson(value, type);
    }

    @TypeConverter
    fun fromListMovie(movie: List<Movie>): String {
        val gson = Gson()
        val value = gson.toJson(movie)
        return value
    }
    //genres
    @TypeConverter
    fun fromStringListGenre(value: String): List<Genre> {
        val type = object : TypeToken<List<Movie>>() {}.type
        return Gson().fromJson(value, type);
    }

    @TypeConverter
    fun fromListGenre(genre: List<Genre>): String {
        val gson = Gson()
        val value = gson.toJson(genre)
        return value
    }
    //trailers
    @TypeConverter
    fun fromStringListTrailer(value: String): List<Trailer> {
        val type = object : TypeToken<List<Movie>>() {}.type
        return Gson().fromJson(value, type);
    }

    @TypeConverter
    fun fromListTrailer(trailer: List<Trailer>): String {
        val gson = Gson()
        val value = gson.toJson(trailer)
        return value
    }
    //reviews
    @TypeConverter
    fun fromStringListReview(value: String): List<Review> {
        val type = object : TypeToken<List<Movie>>() {}.type
        return Gson().fromJson(value, type);
    }

    @TypeConverter
    fun fromListReview(review: List<Review>): String {
        val gson = Gson()
        val value = gson.toJson(review)
        return value
    }
}
