package com.sammy.datasource.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sammy.datasource.cache.movies.Movie
import com.sammy.datasource.cache.movies.MoviesResponse


class Converters {
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
}
