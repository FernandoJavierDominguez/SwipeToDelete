package com.fernandodominguezpacheco.reign.repository

import com.fernandodominguezpacheco.reign.Refresh
import com.fernandodominguezpacheco.reign.Story
import com.fernandodominguezpacheco.reign.datasource.LocalStoryDataSource
import com.fernandodominguezpacheco.reign.datasource.RefreshDataSource
import com.fernandodominguezpacheco.reign.datasource.RemoteStoryDataSource
import kotlinx.coroutines.flow.Flow

class StoryRepository(
    private val localStoryDataSource: LocalStoryDataSource,
    private val remoteStoryDataSource: RemoteStoryDataSource,
    private val refreshDataSource: RefreshDataSource
) {

    suspend fun deleteStory(story: Story) = localStoryDataSource.deleteStory(story)

    fun getAllStories() : Flow<List<Story>> = localStoryDataSource.getAllStories()

    suspend fun addStories(){
        val stories = remoteStoryDataSource.getStories()
        if(localStoryDataSource.isEmpty()) {
            addCacheStories(stories)
        }
        else{
            addNewStories(stories)
        }
    }

    private suspend fun addNewStories(stories: List<Story>){
        val refresh = refreshDataSource.getRefresh()
        localStoryDataSource.addStories(stories.filter {
            it.created_at > refresh.date_refresh
        })
        refresh.date_refresh = stories.first().created_at
        refreshDataSource.updateRefresh(refresh)
    }

    private suspend fun addCacheStories(stories: List<Story>){
            localStoryDataSource.addStories(stories)
            val refresh = Refresh(1, stories.first().created_at )
            refreshDataSource.addRefresh(refresh)
    }
    fun getAllStoriesRoom() : Flow<List<Story>> {
        return localStoryDataSource.getAllStories()
    }
}