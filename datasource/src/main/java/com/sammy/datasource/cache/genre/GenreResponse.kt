package com.sammy.datasource.cache.genre

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Entity
data class GenreResponse(
    @PrimaryKey
    @SerializedName("genres") @Expose
    var genres: List<Genre>
)