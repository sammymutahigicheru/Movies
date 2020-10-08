package com.sammy.movies.details

import androidx.lifecycle.ViewModel
import com.sammy.datasource.datasource.GenreDataSource
import com.sammy.datasource.datasource.ReviewDatasource
import com.sammy.datasource.datasource.TrailerDatasource
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(
    val genreDataSource: GenreDataSource,
    val reviewDatasource: ReviewDatasource, val trailerDatasource: TrailerDatasource
) : ViewModel() {

}