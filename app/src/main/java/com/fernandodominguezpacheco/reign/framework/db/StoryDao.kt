package com.fernandodominguezpacheco.reign.framework.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StoryDao {

    @Query("SELECT * FROM Story ORDER BY created_at DESC")
    suspend fun getAllStories(): List<Story>

    @Query("SELECT COUNT(id) FROM Story")
    fun storyCount(): Int

    @Insert
    suspend fun addStory(story: Story)

    @Insert
    suspend fun addStories(stories : List<Story>)

    @Delete
    suspend fun deleteStory(story: Story)


}