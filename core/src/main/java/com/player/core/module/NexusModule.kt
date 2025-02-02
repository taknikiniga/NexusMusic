package com.player.core.module

import android.content.Context
import androidx.room.Room
import com.player.core.database.NexusDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NexusModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, NexusDB::class.java, "nexus_db").build()


    @Singleton
    @Provides
    fun provideOfflineMusicDao(db: NexusDB) = db.offlineMusicDao()

}