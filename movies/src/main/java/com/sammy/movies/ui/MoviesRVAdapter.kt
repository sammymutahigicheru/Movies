package com.sammy.movies.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sammy.datasource.cache.movies.MoviesResponse
import com.sammy.movies.R
import com.sammy.movies.utils.IMAGE_BASE_URL

class MoviesRVAdapter(
    val movies: MoviesResponse
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.movies.size;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).releaseDate.text = movies.movies[position].releaseDate
        holder.title.text = movies.movies[position].title
       // holder.rating.text = movies.movies[position].rating.toString()
        Glide.with(holder.poster.context)
            .load(IMAGE_BASE_URL + movies.movies[position].posterPath)
            .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
            .into(holder.poster)

    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val releaseDate: TextView = itemView.findViewById(R.id.item_movie_release_date)
        val title: TextView = itemView.findViewById(R.id.item_movie_title)
        val rating: TextView = itemView.findViewById(R.id.item_movie_rating)
        val genres: TextView = itemView.findViewById(R.id.item_movie_genre)
        val poster: ImageView = itemView.findViewById(R.id.item_movie_poster)
    }


    /*fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    val itemCount: Int
        get() = movies.size

    fun appendMovies(moviesToAppend: List<Movie>?) {
        movies.addAll(moviesToAppend!!)
        notifyDataSetChanged()
    }

    fun clearMovies() {
        movies.clear()
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var releaseDate: TextView
        var title: TextView
        var rating: TextView
        var genres: TextView
        var poster: ImageView
        var movie: Movie? = null
        fun bind(movie: Movie) {
            this.movie = movie
            releaseDate.setText(movie.getReleaseDate().split("-").get(0))
            title.setText(movie.getTitle())
            rating.setText(java.lang.String.valueOf(movie.getRating()))
            genres.text = getGenres(movie.getGenreIds())
            Glide.with(itemView)
                .load(IMAGE_BASE_URL + movie.getPosterPath())
                .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
                .into(poster)
        }

        private fun getGenres(genreIds: List<Int>): String {
            val movieGenres: MutableList<String?> =
                ArrayList()
            for (genreId in genreIds) {
                for (genre in allGenres) {
                    if (genre.getId() === genreId) {
                        movieGenres.add(genre.getName())
                        break
                    }
                }
            }
            return TextUtils.join(", ", movieGenres)
        }

        init {
            releaseDate = itemView.findViewById(R.id.item_movie_release_date)
            title = itemView.findViewById(R.id.item_movie_title)
            rating = itemView.findViewById(R.id.item_movie_rating)
            genres = itemView.findViewById(R.id.item_movie_genre)
            poster = itemView.findViewById(R.id.item_movie_poster)
           // itemView.setOnClickListener { callback.onClick(movie) }
        }
    }*/

}