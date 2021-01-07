package com.fernandodominguezpacheco.reign

import com.fernandodominguezpacheco.reign.repository.StoryRepository
import kotlinx.coroutines.flow.Flow

class GetAllStoriesRoom (private val storyRepository: StoryRepository) {

    suspend fun invoke() : Flow<List<Story>> = storyRepository.getAllStoriesRoom()
    
}