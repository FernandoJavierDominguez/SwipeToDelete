package com.fernandodominguezpacheco.reign

import com.fernandodominguezpacheco.reign.repository.StoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class MainActivityModule {

    @Provides
    fun getAllStoriesProvider(storyRepository: StoryRepository) = GetAllStories(storyRepository)

    @Provides
    fun deleteStoryProvider(storyRepository: StoryRepository) = DeleteStory(storyRepository)

}