package com.sammy.datasource.cache.genre

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id") @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    val name: String
)