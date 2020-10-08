package com.sammy.datasource.cache.reviews

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class ReviewResponse(
    @PrimaryKey
    @NonNull
    @SerializedName("results") @Expose
    private var reviews: List<Review>
):Parcelable