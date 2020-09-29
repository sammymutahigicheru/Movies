package com.sammy.movies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sammy.datasource.cache.movies.MoviesResponse
import com.sammy.movies.R
import com.sammy.movies.utils.POPULAR
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject


class MoviesFragment : DaggerFragment() {
    lateinit var adapter: MoviesRVAdapter

    private lateinit var moviesViewModel: MoviesViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        activity!!.setActionBar(toolbar)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initObservers()
        getData(1, POPULAR)
    }
    private fun getData(page:Int,sortBy:String) {
        moviesViewModel.getMovies(page,sortBy).observe(this, Observer {
            if(it != null){
                initRecyclerView(it)
            }

        })
    }


    private fun initViewModel() {
        moviesViewModel = ViewModelProviders.of(this, viewModelFactory)[MoviesViewModel::class.java]
    }



    private fun initObservers() {

        moviesViewModel.moviesLiveData.observe(this, Observer {
            if (it != null)
                initRecyclerView(it)
        })

    }

    private fun initRecyclerView(movies: MoviesResponse) {
        adapter = MoviesRVAdapter(context!!,movies)
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        movies_list.layoutManager = layoutManager
        movies_list.adapter = adapter
    }

}