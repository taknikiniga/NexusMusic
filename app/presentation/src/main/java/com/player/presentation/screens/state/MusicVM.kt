package com.player.presentation.screens.state

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.player.core.database.table.OfflineMusicTable
import com.player.music.mp3.datasource.repo.OfflineMusicRepo
import com.player.music.mp3.datasource.util.state.doOnFailure
import com.player.music.mp3.datasource.util.state.doOnLoading
import com.player.music.mp3.datasource.util.state.doOnSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MusicVM @Inject constructor(private val repo: OfflineMusicRepo) : ViewModel() {

    private val _songs = MutableStateFlow<List<OfflineMusicTable>>(emptyList())
    val songs = _songs.asStateFlow()

    fun getOfflineSongs() {
        viewModelScope.launch {
            repo.getOfflineMusic().doOnSuccess { songs ->

                songs?.let {

                    _songs.value = it
//                    Log.e("getOfflineSongs: ", "Success ->>> ${it.size}")

                }

            }.doOnLoading { songs ->
                songs?.let {
                    _songs.value = it
//                    Log.e("getOfflineSongs: ", "Success ->>> ${it.size}")
                }

            }
                .doOnFailure { throwable, songs ->

                    songs?.let {
                        _songs.value = it
                    }
//                    Log.e("getOfflineSongs: ", "Success ->>> ${songs?.size}")

                }.collect()
        }
    }

}