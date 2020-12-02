package com.fernandodominguezpacheco.reign.framework.server

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

data class StoryResponse(
    val hits: List<Story>,
)

