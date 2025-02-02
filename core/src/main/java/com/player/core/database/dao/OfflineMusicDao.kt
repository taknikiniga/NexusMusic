package com.player.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.player.core.database.table.OfflineMusicTable
import kotlinx.coroutines.flow.Flow


@Dao
interface OfflineMusicDao {

    @Upsert
    suspend fun upsertOfflineMusic(offlineMusic: List<OfflineMusicTable>)

    @Query("SELECT * FROM offline_music_table")
    fun getOfflineMusic(): Flow<List<OfflineMusicTable>>


}