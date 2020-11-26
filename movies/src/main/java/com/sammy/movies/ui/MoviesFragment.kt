package com.sammy.movies.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sammy.datasource.cache.movies.MoviesResponse
import com.sammy.movies.R
import com.sammy.movies.details.MovieDetailsActivity
import com.sammy.movies.utils.POPULAR
import com.sammy.movies.utils.TOP_RATED
import com.sammy.movies.utils.UPCOMING
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject

class MoviesFragment : Fragment() {
    lateinit var adapter: MoviesRVAdapter
    private val moviesViewModel: MoviesViewModel by viewModels()
    private var sortBy = POPULAR
    private var isFetchingMovies: Boolean = false
    private var currentPage = 1




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        requireActivity().setActionBar(toolbar)
        toolbar.inflateMenu(R.menu.menu_movies_sort)
        toolbar.setOnMenuItemClickListener {
            onOptionsItemSelected(it)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        getData(currentPage)
        setupOnScrollListener()

    }

    private fun setupOnScrollListener() {
        val manager = LinearLayoutManager(context)
        movies_list.setLayoutManager(manager)
        movies_list.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val totalItemCount = manager.itemCount
                val visibleItemCount = manager.childCount
                val firstVisibleItem = manager.findFirstVisibleItemPosition()
                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    if (!isFetchingMovies) {
                        getData(currentPage + 1)
                    }
                }
            }
        })
    }

    private fun getData(page: Int) {
        isFetchingMovies = true
        moviesViewModel.getMovies(page, sortBy).observe(viewLifecycleOwner, Observer { movie ->
            run {
                if (movie != null) {
                    initRecyclerView(movie)
                    isFetchingMovies = false
                    currentPage = page
                    setTitle()
                }
            }

        })


    }

    private fun setTitle() {
        if (sortBy == POPULAR) {
            requireActivity().title = "Popular"
        } else if (sortBy == TOP_RATED) {
            requireActivity().title = "Top Rated"
        } else {
            requireActivity().title = "Upcoming"
        }
    }

    private fun initObservers() {

        moviesViewModel.moviesLiveData.observe(viewLifecycleOwner, Observer { movie ->
            run {
                if (movie != null) {
                    initRecyclerView(movie)
                }
            }


        })

    }

    private fun initRecyclerView(
        movies: MoviesResponse
    ) {
        adapter = MoviesRVAdapter(movies)
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        movies_list.layoutManager = layoutManager
        movies_list.adapter = adapter
        adapter.onItemClick = { movie ->
            run {
                val intent = Intent(requireActivity(), MovieDetailsActivity::class.java)
                intent.putExtra("movie", movie)
                requireActivity().startActivity(intent)
            }

        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        currentPage = 1
        when (item.itemId) {
            R.id.popular -> {
                sortBy = POPULAR
                getData(currentPage)
                true
            }
            R.id.top_rated -> {
                sortBy = TOP_RATED
                getData(currentPage)
                true
            }
            R.id.upcoming -> {
                sortBy = UPCOMING
                getData(currentPage)
                true
            }
            else -> false
        }
        return true
    }

}