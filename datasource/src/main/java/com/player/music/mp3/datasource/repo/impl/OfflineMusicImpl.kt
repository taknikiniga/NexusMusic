package com.player.music.mp3.datasource.repo.impl

import com.player.core.database.dao.OfflineMusicDao
import com.player.core.database.table.OfflineMusicTable
import com.player.music.mp3.datasource.repo.OfflineMusicRepo
import com.player.music.mp3.datasource.system.mediastore.AudioMedia
import com.player.music.mp3.datasource.util.mediaBoundResource
import com.player.music.mp3.datasource.util.state.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OfflineMusicImpl @Inject constructor(
    private val dao: OfflineMusicDao,
    private val mediaStore: AudioMedia
) :
    OfflineMusicRepo {
    override fun getOfflineMusic(): Flow<Resource<List<OfflineMusicTable>>> {
        return mediaBoundResource(query = { dao.getOfflineMusic() }, saveFetchResult = { songList ->

            songList?.let {
                dao.upsertOfflineMusic(it)
            }
        }, fetch = {
            mediaStore.getAudio()
        })
    }

}