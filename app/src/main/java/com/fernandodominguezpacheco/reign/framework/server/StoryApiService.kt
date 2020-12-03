package com.fernandodominguezpacheco.reign.framework.server

import retrofit2.http.GET

interface StoryApiService {

    @GET("search_by_date?query=android")
    suspend fun  getAllStories() : StoryResponse
}