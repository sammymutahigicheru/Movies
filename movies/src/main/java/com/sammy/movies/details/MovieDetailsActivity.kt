package com.sammy.movies.details

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.TextView
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sammy.datasource.cache.genre.GenreResponse
import com.sammy.datasource.cache.movies.Movie
import com.sammy.datasource.cache.reviews.ReviewResponse
import com.sammy.datasource.cache.trailer.TrailerResponse
import com.sammy.movies.R
import com.sammy.movies.base.MovieDetailsProvider
import kotlinx.android.synthetic.main.activity_movie_details.*
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity() {

    lateinit var movie:Movie
    lateinit var genreResponse:GenreResponse
    lateinit var trailersResponse:TrailerResponse
    lateinit var reviewResponse: ReviewResponse

    private lateinit var moviesViewModel: MovieDetailsViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        //inject
        val movieDetailsComponent =  (applicationContext as MovieDetailsProvider)
            .provideMovieDetailsComponent()
        movieDetailsComponent.inject(this)
        //get intent
        movie = intent.getParcelableExtra("movie")!!
        setupToolbar()
        initViewModel()
        initObservers()
        getData()
        initItems()

    }

    private fun getData() {
        //get reviews
        moviesViewModel.getReviews(movie.id!!).observe(this, Observer { reviews ->
            run {
                if (reviews != null) {
                    initReviews(reviews)
                }
            }

        })
        //get Trailers
        moviesViewModel.getTrailers(movie.id!!).observe(this, Observer { trailers ->
            run {
                if (trailers != null) {
                    initTrailers(trailers)
                }
            }

        })
        //get genre
        moviesViewModel.getGenre().observe(this, Observer { genres ->
            run {
                if (genres != null) {
                    initGenre(genres)
                }
            }

        })
    }

    private fun initViewModel() {
        moviesViewModel = ViewModelProviders.of(this, viewModelFactory)[MovieDetailsViewModel::class.java]
    }
    private fun initObservers() {
        //genres
        moviesViewModel.genreLiveData.observe(this, Observer { genres ->
            run {
                if (genres != null) {
                    initGenre(genres)
                }
            }


        })
        //reviews
        moviesViewModel.reviewLiveData.observe(this, Observer { reviews ->
            run {
                if (reviews != null) {
                    initReviews(reviews)
                }
            }


        })
        //trailers
        moviesViewModel.trailerLiveData.observe(this, Observer { trailers ->
            run {
                if (trailers != null) {
                    initTrailers(trailers)
                }
            }


        })

    }

    private fun initTrailers(trailers: TrailerResponse) {
        trailersResponse = trailers
    }

    private fun initReviews(reviews: ReviewResponse) {
        reviewResponse = reviews

    }

    private fun initGenre(genre: GenreResponse) {
        genreResponse = genre
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
        getGenre()
        getReviews()
    }

    private fun getReviews() {
        if(reviewResponse.reviews != null){
            reviewsLabel.visibility = View.VISIBLE
            movieReviews.removeAllViews()
            for(review in reviewResponse.reviews){
                val parent =
                    layoutInflater.inflate(R.layout.review, movieReviews, false)
                val author = parent.findViewById<TextView>(R.id.reviewAuthor)
                val content = parent.findViewById<TextView>(R.id.reviewContent)
                author.text = review.author
                content.text = review.content
                movieReviews.addView(parent)
            }

        }
    }

    private fun getGenre() {
        if(movie.genres != null){
            val currentGenres:MutableList<String> = ArrayList()
            for (genre in movie.genres!!){
                currentGenres.add(genre.name!!)
            }
            movieDetailsGenres.text = TextUtils.join(", ", currentGenres)
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