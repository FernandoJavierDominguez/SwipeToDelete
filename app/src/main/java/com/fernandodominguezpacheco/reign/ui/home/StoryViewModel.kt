package com.fernandodominguezpacheco.reign.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fernandodominguezpacheco.reign.DeleteStory
import com.fernandodominguezpacheco.reign.GetAllStories
import com.fernandodominguezpacheco.reign.Story
import kotlinx.coroutines.launch

class StoryViewModel @ViewModelInject constructor(
    private val getAllStories: GetAllStories,
    private val deleteStory: DeleteStory
) : ViewModel(){


    private val _storyItems = MutableLiveData<List<Story>>()
    val storyItems: LiveData<List<Story>> get() = _storyItems

    init {
        getStories()
    }

    fun getStories(){
        viewModelScope.launch {
            _storyItems.value = getAllStories.invoke()
        }

    }
    fun deleteStory(story: Story){
        viewModelScope.launch {
            deleteStory.invoke(story)
        }
    }



}