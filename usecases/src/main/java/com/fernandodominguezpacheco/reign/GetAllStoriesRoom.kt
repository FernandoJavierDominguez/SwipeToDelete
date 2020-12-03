package com.fernandodominguezpacheco.reign

import com.fernandodominguezpacheco.reign.repository.StoryRepository

class GetAllStoriesRoom (private val storyRepository: StoryRepository) {

    suspend fun invoke() : List<Story> = storyRepository.getAllStoriesRoom()

}