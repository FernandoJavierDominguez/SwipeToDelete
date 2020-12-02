package com.fernandodominguezpacheco.reign.framework.di

import android.app.Application
import androidx.room.Room
import com.fernandodominguezpacheco.reign.BuildConfig
import com.fernandodominguezpacheco.reign.datasource.LocalStoryDataSource
import com.fernandodominguezpacheco.reign.datasource.RefreshDataSource
import com.fernandodominguezpacheco.reign.datasource.RemoteStoryDataSource
import com.fernandodominguezpacheco.reign.framework.db.RoomRefreshDataSource
import com.fernandodominguezpacheco.reign.framework.db.RoomStoryDataSource
import com.fernandodominguezpacheco.reign.framework.db.StoryDb
import com.fernandodominguezpacheco.reign.framework.server.StoryApiDataSource
import com.fernandodominguezpacheco.reign.framework.server.StoryApiService
import com.fernandodominguezpacheco.reign.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {
    //LOCAL DATA SOURCE
    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        StoryDb::class.java,
        "checklist-db"
    ).build()

    @Provides
    fun localStoryDataSourceProvider(db: StoryDb) : LocalStoryDataSource = RoomStoryDataSource(db)

    @Provides
    fun refreshDataSourceProvider(db: StoryDb) : RefreshDataSource = RoomRefreshDataSource(db)

    //SERVER DATA SOURCE
    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }else{
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL:String): StoryApiService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()
        .run{ create(StoryApiService::class.java) }

    @Provides
    fun remoteStoryDataSourceProvider(apiService: StoryApiService) : RemoteStoryDataSource =  StoryApiDataSource(apiService)


}