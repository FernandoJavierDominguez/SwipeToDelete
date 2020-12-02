package com.fernandodominguezpacheco.reign.framework.db

import com.fernandodominguezpacheco.reign.Story
import com.fernandodominguezpacheco.reign.datasource.LocalStoryDataSource
import com.fernandodominguezpacheco.reign.framework.toRoomStory
import com.fernandodominguezpacheco.reign.framework.toStory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomStoryDataSource(db: StoryDb) : LocalStoryDataSource {

    private val storyDao = db.storyDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO){ storyDao.storyCount() <= 0}


    override suspend fun addStory(story: Story) {
        withContext(Dispatchers.IO){
            storyDao.addStory(story.toRoomStory())
        }
    }

    override suspend fun addStories(stories: List<Story>) {
       withContext(Dispatchers.IO){
           storyDao.addStories(stories.map { it.toRoomStory() })
       }
    }

    override suspend fun deleteStory(story: Story) {
        withContext(Dispatchers.IO){
            storyDao.deleteStory(story.toRoomStory())
        }
    }

    override suspend fun getAllStories() : List<Story> = withContext(Dispatchers.IO) {
            storyDao.getAllStories().map { it.toStory() }
    }

}