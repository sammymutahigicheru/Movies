package com.sammy.datasource.cache.reviews

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("author") @Expose
    private var author: String? = null,

    @SerializedName("content")
    @Expose
    private val content: String? = null
)