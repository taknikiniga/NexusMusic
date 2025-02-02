package com.player.core.database.table

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "offline_music_table")
data class OfflineMusicTable(
    @PrimaryKey(autoGenerate = false)
    val _id: Long = 0,
    val path: String = "",
    val name: String = ""
)
