package com.fernandodominguezpacheco.reign.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


fun <T> LifecycleOwner.observer(liveData: LiveData<T>, observer: (T) -> Unit ){
    liveData.observe(this, Observer(observer))
}
