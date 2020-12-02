package com.fernandodominguezpacheco.reign.framework.server

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Story(
    @SerializedName("created_at") val created_at : Date,
    @SerializedName("author") val author : String?,
    @SerializedName("story_title") val story_title : String?,
    @SerializedName("story_url")  val story_url : String?,
): Parcelable