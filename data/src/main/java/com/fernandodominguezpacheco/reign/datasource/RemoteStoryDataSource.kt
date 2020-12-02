package com.fernandodominguezpacheco.reign.datasource

import com.fernandodominguezpacheco.reign.Story


interface RemoteStoryDataSource {

    suspend fun getStories(): List<Story>

}