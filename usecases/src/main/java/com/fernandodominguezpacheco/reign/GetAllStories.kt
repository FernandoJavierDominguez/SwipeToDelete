package com.fernandodominguezpacheco.reign

import com.fernandodominguezpacheco.reign.repository.StoryRepository

class GetAllStories (private val storyRepository: StoryRepository) {

    suspend fun invoke() : List<Story> = storyRepository.getAllStories()

}