package com.sammy.datasource.cache.reviews

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Review(
    @SerializedName("author") @Expose
    private var author: String? = null,

    @SerializedName("content")
    @Expose
    private val content: String? = null
):Parcelable