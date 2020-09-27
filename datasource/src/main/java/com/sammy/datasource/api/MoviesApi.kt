package com.sammy.datasource.api

import com.sammy.datasource.cache.genre.GenreResponse
import com.sammy.datasource.cache.movies.Movie
import com.sammy.datasource.cache.movies.MoviesResponse
import com.sammy.datasource.cache.reviews.ReviewResponse
import com.sammy.datasource.cache.trailer.TrailerResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int
    ): Call<MoviesResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int
    ): Call<MoviesResponse?>?

    @GET("movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?,
        @Query("page") page: Int
    ): Call<MoviesResponse?>?

    @GET("genre/movie/list")
    fun getGenres(
        @Query("api_key") apiKey: String?,
        @Query("language") language: String?
    ): Call<GenreResponse?>?

    @GET("movie/{movie_id}")
    fun getMovie(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKEy: String?,
        @Query("language") language: String?
    ): Call<Movie?>?

    @GET("movie/{movie_id}/videos")
    fun getTrailers(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKEy: String?,
        @Query("language") language: String?
    ): Call<TrailerResponse?>?

    @GET("movie/{movie_id}/reviews")
    fun getReviews(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKEy: String?,
        @Query("language") language: String?
    ): Call<ReviewResponse?>?
}