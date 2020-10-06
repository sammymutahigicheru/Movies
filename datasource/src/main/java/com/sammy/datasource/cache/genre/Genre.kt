package com.sammy.datasource.cache.genre

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Genre(
    var id: Int?=null,

    val name: String?=null
):Parcelable