package com.fernandodominguezpacheco.reign.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.fernandodominguezpacheco.reign.DeleteStory
import com.fernandodominguezpacheco.reign.GetAllStories
import com.fernandodominguezpacheco.reign.Story
import com.fernandodominguezpacheco.reign.repository.StoryRepository
import kotlinx.coroutines.launch

class StoryViewModel @ViewModelInject constructor(
    private val getAllStories: GetAllStories,
    private val deleteStory: DeleteStory,
    private val storyRepository: StoryRepository
) : ViewModel(){


    val storyItems = getAllStories.invoke().asLiveData()

    init {
        addStories()
    }


    fun addStories(){
        viewModelScope.launch {
            storyRepository.addStories()
        }

    }

    fun deleteStory(story: Story){
        viewModelScope.launch {
            deleteStory.invoke(story)
        }
    }



}