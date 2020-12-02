package com.fernandodominguezpacheco.reign

import com.fernandodominguezpacheco.reign.repository.StoryRepository

class DeleteStory( private val storyRepository: StoryRepository){

    suspend fun invoke(story: Story) = storyRepository.deleteStory(story)

}