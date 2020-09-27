package com.sammy.datasource.cache.genre

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id") @Expose
    private var id: Int = 0,

    @SerializedName("name")
    @Expose
    private val name: String? = null
)