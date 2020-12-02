package com.fernandodominguezpacheco.reign.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fernandodominguezpacheco.reign.Story

class SharedViewModel : ViewModel() {

    private val selectedStory = MutableLiveData<Story>()

    fun selectStory(story: Story){
        selectedStory.value = story
    }
    fun getSelectedStory() : LiveData<Story> {
        return selectedStory
    }
}