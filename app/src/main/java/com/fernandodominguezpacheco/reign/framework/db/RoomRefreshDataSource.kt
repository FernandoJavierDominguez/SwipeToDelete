package com.fernandodominguezpacheco.reign.framework.db

import com.fernandodominguezpacheco.reign.Refresh
import com.fernandodominguezpacheco.reign.Story
import com.fernandodominguezpacheco.reign.datasource.RefreshDataSource
import com.fernandodominguezpacheco.reign.framework.toRefresh
import com.fernandodominguezpacheco.reign.framework.toRoomRefresh
import com.fernandodominguezpacheco.reign.framework.toStory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomRefreshDataSource(db: StoryDb) : RefreshDataSource {

    private val refreshDao = db.refreshDao()

    override suspend fun isEmpty(): Boolean = withContext(Dispatchers.IO){
        refreshDao.refreshCount() <= 0
    }

    override suspend fun addRefresh(refresh: Refresh) {
        withContext(Dispatchers.IO){
            refreshDao.addRefresh(refresh.toRoomRefresh())
        }
    }

    override suspend fun updateRefresh(refresh: Refresh) {
        withContext(Dispatchers.IO){
            refreshDao.updateRefresh(refresh.toRoomRefresh())
        }
    }

    override suspend fun deleteRefresh(refresh: Refresh) {
        withContext(Dispatchers.IO){
            refreshDao.deleteRefresh(refresh.toRoomRefresh())
        }
    }

    override suspend fun getRefresh(): Refresh = withContext(Dispatchers.IO) {
        refreshDao.getRefresh().toRefresh()
    }
}