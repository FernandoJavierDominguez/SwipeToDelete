package com.fernandodominguezpacheco.reign.framework.di

import com.fernandodominguezpacheco.reign.datasource.LocalStoryDataSource
import com.fernandodominguezpacheco.reign.datasource.RefreshDataSource
import com.fernandodominguezpacheco.reign.datasource.RemoteStoryDataSource
import com.fernandodominguezpacheco.reign.repository.StoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class DataModule {

    @Provides
    fun storyRepositoryProvider(
        localStoryDataSource: LocalStoryDataSource,
        remoteStoryDataSource: RemoteStoryDataSource,
        refreshDataSource: RefreshDataSource
    ) = StoryRepository(localStoryDataSource, remoteStoryDataSource, refreshDataSource)
}