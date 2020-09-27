package com.sammy.datasource.cache.reviews

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ReviewResponse(
    @SerializedName("results") @Expose
    private var reviews: List<Review?>? = null
)