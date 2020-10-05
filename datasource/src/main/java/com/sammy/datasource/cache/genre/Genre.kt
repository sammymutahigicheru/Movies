package com.sammy.datasource.cache.genre

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Genre(
    @PrimaryKey
    @NonNull
    @SerializedName("id") @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    val name: String
)