package com.player.music.mp3.datasource.system.mediastore

import android.content.ContentResolver
import android.provider.MediaStore
import android.util.Log
import com.player.core.database.dao.OfflineMusicDao
import com.player.core.database.table.OfflineMusicTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AudioMedia @Inject constructor(
    private val contentResolver: ContentResolver
) {
    suspend fun getAudio(): MutableList<OfflineMusicTable>? {
        val songList = mutableListOf<OfflineMusicTable>()
        return withContext(Dispatchers.Default) {
            val projection = listOf(
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DATA,
            )

            contentResolver.query(
                MediaStore.Files.getContentUri("external"),
                projection.toTypedArray(),
                null,
                null,
                null
            )?.use {


                val _id = it.getColumnIndex(MediaStore.Audio.Media._ID)
                val name = it.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)
                val path = it.getColumnIndex(MediaStore.Audio.Media.DATA)


                while (it.moveToNext()) {
                    val id = it.getLong(_id)
                    val name = it.getString(name)
                    val path = it.getString(path)

                    songList.add(OfflineMusicTable(_id = id, name = name, path = path))


                }

                songList


            }
        }
    }
}