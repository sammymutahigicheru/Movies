package com.sammy.movies.details

import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sammy.datasource.cache.movies.Movie
import com.sammy.movies.R
import com.sammy.movies.utils.IMAGE_BASE_URL
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : DaggerAppCompatActivity() {
    lateinit var movie:Movie
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        movie = intent.getParcelableExtra("movie")!!
        setupToolbar()
        initItems()
    }

    private fun initItems() {
        movieDetailsTitle.text = movie.title
        summaryLabel.visibility= View.VISIBLE
        movieDetailsOverview.text = movie.overview
        movieDetailsRating.visibility =  View.VISIBLE
        movieDetailsRating.rating = movie.rating!!.div(2)
        movieDetailsReleaseDate.text = movie.releaseDate
        if (!isFinishing) {
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500${movie.backdrop}")
                .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
                .into(movieDetailsBackdrop)
        }
    }

    private fun setupToolbar() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setActionBar(toolbar)
        setTitle(" ")
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowTitleEnabled(false)
        }
    }


}