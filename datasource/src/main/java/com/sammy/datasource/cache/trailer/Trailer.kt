package com.sammy.datasource.cache.trailer

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Trailer(
    @SerializedName("key") @Expose
    private var key: String? = null
)