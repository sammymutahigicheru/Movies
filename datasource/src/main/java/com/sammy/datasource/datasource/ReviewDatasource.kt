package com.sammy.datasource.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import com.app.network.cache.Listener
import com.sammy.datasource.NetworkClient
import com.sammy.datasource.api.MoviesApi
import com.sammy.datasource.cache.reviews.ReviewPersist
import com.sammy.datasource.cache.reviews.ReviewResponse
import com.sammy.datasource.utils.API_KEY
import com.sammy.datasource.utils.LANGUAGE
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewDatasource(
    private val networkClient: NetworkClient<MoviesApi>,
    val reviewPersist: ReviewPersist
) {
    fun getReviews(id:Int,listener: Listener<ReviewResponse>): LiveData<ReviewResponse> {
        networkClient.getRetrofitService(MoviesApi::class.java).getReviews(id, API_KEY, LANGUAGE)
            .enqueue(object : Callback<ReviewResponse> {
                override fun onFailure(call: Call<ReviewResponse>, t: Throwable) {
                    Log.d("response_posts", t.message!!)
                }

                override fun onResponse(
                    call: Call<ReviewResponse>,
                    response: Response<ReviewResponse>
                ) {
                    response.body()?.let {
                        listener.onResponse(response = it)
                        GlobalScope.launch {
                            reviewPersist.save(it)
                        }
                    }
                }
            })
        return reviewPersist.load()
    }
}