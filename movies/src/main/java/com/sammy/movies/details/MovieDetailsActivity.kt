package com.sammy.movies.details

import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.sammy.datasource.cache.movies.Movie
import com.sammy.movies.R

class MovieDetailsActivity : AppCompatActivity() {
    lateinit var movie:Movie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        movie = intent.getParcelableExtra<Movie>("movie")!!
        setupToolbar()
    }

    private fun setupToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setActionBar(toolbar)
        setTitle(movie.title)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
        }
    }


}