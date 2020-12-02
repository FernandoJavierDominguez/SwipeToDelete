package com.fernandodominguezpacheco.reign.framework.db

import androidx.room.*

@Dao
interface RefreshDao {

    @Query("SELECT * FROM Refresh")
    suspend fun getRefresh(): Refresh

    @Query("SELECT COUNT(id) FROM Refresh")
    fun refreshCount(): Int

    @Insert
    suspend fun addRefresh(refresh: Refresh)

    @Update
    suspend fun updateRefresh(refresh: Refresh)

    @Delete
    suspend fun deleteRefresh(refresh: Refresh)


}