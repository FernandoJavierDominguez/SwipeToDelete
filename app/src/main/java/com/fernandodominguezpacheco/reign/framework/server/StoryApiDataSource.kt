package com.fernandodominguezpacheco.reign.framework.server

import com.fernandodominguezpacheco.reign.Story
import com.fernandodominguezpacheco.reign.datasource.RemoteStoryDataSource
import com.fernandodominguezpacheco.reign.framework.toStory
import javax.inject.Inject

class StoryApiDataSource @Inject constructor(
    private val apiService: StoryApiService
): RemoteStoryDataSource{

    override suspend fun getStories(): MutableList<Story> = apiService.getAllStories().hits.map { it.toStory() }.toMutableList()

}