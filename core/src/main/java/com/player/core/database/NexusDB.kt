package com.player.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.player.core.database.dao.OfflineMusicDao
import com.player.core.database.table.OfflineMusicTable


@Database(entities = [OfflineMusicTable::class], version = 1, exportSchema = false)
abstract class NexusDB : RoomDatabase() {

    abstract fun offlineMusicDao(): OfflineMusicDao

}