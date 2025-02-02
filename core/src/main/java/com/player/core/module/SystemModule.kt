package com.player.core.module

import android.content.ContentResolver
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SystemModule {


    @Singleton
    @Provides
    fun provideAudioMedia(@ApplicationContext context: Context) = context.contentResolver

}