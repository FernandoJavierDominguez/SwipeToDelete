package com.fernandodominguezpacheco.reign

import com.fernandodominguezpacheco.reign.repository.StoryRepository
import kotlinx.coroutines.flow.Flow

class GetAllStories (private val storyRepository: StoryRepository) {

    fun invoke() : Flow<List<Story>> = storyRepository.getAllStories()

}