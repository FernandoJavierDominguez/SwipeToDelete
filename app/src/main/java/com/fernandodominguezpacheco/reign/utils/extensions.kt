package com.fernandodominguezpacheco.reign.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.*


fun <T> LifecycleOwner.observer(liveData: LiveData<T>, observer: (T) -> Unit ){
    liveData.observe(this, Observer(observer))
}

fun Date.changeDate() : String{

    val diff: Long = Date().time - this.time
    val seconds = diff / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24
    return when  {
        minutes in 60..1439 -> "$hours h"
        minutes > 1439 -> "$days d"
        else -> "$minutes m"
    }.replace("\\s".toRegex(),"")
}
