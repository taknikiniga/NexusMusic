package com.player.music.mp3.datasource.repo

import com.player.core.database.table.OfflineMusicTable
import com.player.music.mp3.datasource.util.state.Resource
import kotlinx.coroutines.flow.Flow

interface OfflineMusicRepo {

    fun getOfflineMusic(): Flow<Resource<List<OfflineMusicTable>>>


}