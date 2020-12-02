package com.fernandodominguezpacheco.reign.datasource

import com.fernandodominguezpacheco.reign.Story

interface LocalStoryDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun addStory(story: Story)
    suspend fun addStories(stories: List<Story>)
    suspend fun deleteStory(story: Story)
    suspend fun getAllStories() : List<Story>
}