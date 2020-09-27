package com.sammy.datasource.cache.genre

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("genres") @Expose
    private var genres: List<Genre?>? = null
)