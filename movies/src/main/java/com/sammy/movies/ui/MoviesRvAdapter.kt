package com.sammy.movies.ui

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sammy.datasource.cache.genre.GenreResponse
import com.sammy.datasource.cache.movies.Movie
import com.sammy.datasource.cache.movies.MoviesResponse
import com.sammy.movies.R
import com.squareup.picasso.Picasso
import okhttp3.internal.userAgent
import java.util.*

class MoviesRVAdapter(
    val movies: MoviesResponse,
    val genres: GenreResponse
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onItemClick:((Movie)->Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.movies.size;
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).releaseDate.text =
            movies.movies[position].releaseDate!!.split("-")[0]
        holder.title.text = movies.movies[position].title
        holder.rating.text = movies.movies[position].rating.toString()
       // holder.genres.text = getGenres(movies.movies[position].genreIds)
        Picasso.get().load("https://image.tmdb.org/t/p/w500${movies.movies[position].posterPath}")
            .into(holder.poster)


    }

    private fun getGenres(genreIds: List<Int>): String {
        val movieGenres: MutableList<String?> =
            ArrayList()
        for (genreId in genreIds) {
            for (genre in genres.genres) {
                if (genre.id == genreId) {
                    movieGenres.add(genre.name)
                    break
                }
            }
        }
        return TextUtils.join(", ", movieGenres)
    }

   inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val releaseDate: TextView = itemView.findViewById(R.id.item_movie_release_date)
        val title: TextView = itemView.findViewById(R.id.item_movie_title)
        val rating: TextView = itemView.findViewById(R.id.item_movie_rating)
        val genres: TextView = itemView.findViewById(R.id.item_movie_genre)
        val poster: ImageView = itemView.findViewById(R.id.item_movie_poster)
        init{
            itemView.setOnClickListener {
                onItemClick?.invoke(movies.movies[adapterPosition])
            }
        }
    }


}