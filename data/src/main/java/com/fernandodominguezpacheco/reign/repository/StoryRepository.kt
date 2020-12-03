package com.fernandodominguezpacheco.reign.repository

import com.fernandodominguezpacheco.reign.Refresh
import com.fernandodominguezpacheco.reign.Story
import com.fernandodominguezpacheco.reign.datasource.LocalStoryDataSource
import com.fernandodominguezpacheco.reign.datasource.RefreshDataSource
import com.fernandodominguezpacheco.reign.datasource.RemoteStoryDataSource

class StoryRepository(
    private val localStoryDataSource: LocalStoryDataSource,
    private val remoteStoryDataSource: RemoteStoryDataSource,
    private val refreshDataSource: RefreshDataSource
) {

    suspend fun deleteStory(story: Story) = localStoryDataSource.deleteStory(story)

    suspend fun getAllStories() : List<Story> {

        val stories = remoteStoryDataSource.getStories()
        if(localStoryDataSource.isEmpty()){
            localStoryDataSource.addStories(stories)
            val refresh = Refresh(1, stories.first().created_at )
            refreshDataSource.addRefresh(refresh)
        }
        else{
            val refresh = refreshDataSource.getRefresh()
            localStoryDataSource.addStories(stories.filter {
                it.created_at > refresh.date_refresh
            })
            refresh.date_refresh = stories.first().created_at
            refreshDataSource.updateRefresh(refresh)
        }
        return localStoryDataSource.getAllStories()
    }
    suspend fun getAllStoriesRoom() : List<Story> {
        return localStoryDataSource.getAllStories()
    }
}