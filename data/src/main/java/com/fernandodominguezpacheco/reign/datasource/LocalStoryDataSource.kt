package com.fernandodominguezpacheco.reign.datasource

import com.fernandodominguezpacheco.reign.Story
import kotlinx.coroutines.flow.Flow

interface LocalStoryDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun addStory(story: Story)
    suspend fun addStories(stories: List<Story>)
    suspend fun deleteStory(story: Story)
    fun getAllStories() : Flow<List<Story>>
}