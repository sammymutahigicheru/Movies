package com.sammy.datasource.cache.trailer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TrailerResponse(
    @SerializedName("results") @Expose
    private var trailers: List<Trailer?>? = null
)