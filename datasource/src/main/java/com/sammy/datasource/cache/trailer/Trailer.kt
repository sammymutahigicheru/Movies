package com.sammy.datasource.cache.trailer

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Trailer(
    @SerializedName("key") @Expose
    private var key: String? = null
):Parcelable