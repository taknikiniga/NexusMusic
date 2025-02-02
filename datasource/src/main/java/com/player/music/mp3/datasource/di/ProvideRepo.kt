package com.player.music.mp3.datasource.di

import com.player.music.mp3.datasource.repo.OfflineMusicRepo
import com.player.music.mp3.datasource.repo.impl.OfflineMusicImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class ProvideRepo {

    @Binds
    abstract fun provideRepo(repo: OfflineMusicImpl): OfflineMusicRepo

}