package com.fernandodominguezpacheco.reign.datasource

import com.fernandodominguezpacheco.reign.Refresh
import com.fernandodominguezpacheco.reign.Story

interface RefreshDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun addRefresh(refresh: Refresh)
    suspend fun updateRefresh(refresh: Refresh)
    suspend fun deleteRefresh(refresh: Refresh)
    suspend fun getRefresh() : Refresh
}