package com.player.presentation.screens.pages.other

import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.SkipNext
import androidx.compose.material.icons.rounded.SkipPrevious
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.player.core.database.table.OfflineMusicTable
import com.player.presentation.screens.state.MusicVM
import java.io.File

@Composable
fun PlayerScreen(vm: MusicVM) {

    val songs = vm.songs.collectAsState().value


    val context = LocalContext.current

    var showPlayerLoader by remember {
        mutableStateOf(true)
    }

    var _isPlaying by remember {
        mutableStateOf(false)
    }

    var player by remember {
        mutableStateOf<ExoPlayer?>(null)
    }

    LaunchedEffect(false) {
        player = ExoPlayer.Builder(context).build()

//        val firstUri =
//            Uri.parse("https://cdn.pixabay.com/download/audio/2023/11/18/audio_178dcdfe7b.mp3?filename=madcap-scheme-176851.mp3")
//        val secondUri =
//            Uri.parse("https://cdn.pixabay.com/download/audio/2024/11/06/audio_33c64c23bb.mp3?filename=comedy-music-humor-quirky-joke-silly-background-intro-theme-260574.mp3")
//        val firstItem = MediaItem.fromUri(firstUri)
//        val secondItem = MediaItem.fromUri(secondUri)
//
//        player?.let {
//            it.setMediaItem(firstItem)
//            it.setMediaItem(secondItem)
//            it.setMediaItems(
//                listOf(
//                    firstItem,
//                    secondItem
//                )
//            )
//            it.prepare()
//        }

    }

    /*Feature Song List*/
    FeatureMusic(songList = songs) {song ->
        player?.let {
            it.setMediaItem(MediaItem.fromUri(Uri.fromFile(File(song))))
            it.prepare()
        }

    }

    player?.let {

        player?.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                super.onPlaybackStateChanged(playbackState)

                when (playbackState) {
                    Player.STATE_READY -> {
                        Log.e("onPlaybackStateChanged: ", "STATE_READY")
                        player?.play()
                        showPlayerLoader = false
                    }

                    Player.STATE_ENDED -> {
                        Log.e("onPlaybackStateChanged: ", "STATE_ENDED")
                        showPlayerLoader = false

                    }

                    Player.STATE_IDLE -> {
                        Log.e("onPlaybackStateChanged: ", "STATE_IDLE")
                        showPlayerLoader = false

                    }

                    Player.STATE_BUFFERING -> {
                        Log.e("onPlaybackStateChanged: ", "STATE_BUFFERING")
                    }
                }
            }

            override fun onIsPlayingChanged(isPlaying: Boolean) {
                super.onIsPlayingChanged(isPlaying)
                _isPlaying = isPlaying
//            showPlayerLoader = !isPlaying

            }
        })

//    player.prepare()
//    player.play()

//        AnimatedVisibility(showPlayerLoader) {
//            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
//                CircularProgressIndicator()
//            }
//        }
//
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//
//            PlayerUi(isPlay = _isPlaying, onPlayClick = {
//                if (_isPlaying) it.pause() else {
//                    it.play()
//                }
//
//            }, onPreviousClick = {
//                it.seekToPrevious()
//            }, onNextClick = {
//                it.seekToNext()
//            })
//
//        }

    }

}

@Composable
fun FeatureMusic(
    modifier: Modifier = Modifier,
    songList: List<OfflineMusicTable>,
    onClick: (String) -> Unit
) {

    val state = rememberLazyListState()

    LazyColumn(state = state) {
        items(songList, key = {
            it._id
        }) {

            Surface(modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(), onClick = {
                onClick(it.path)
            }) {
                Text(
                    text = it.name,
                    modifier = Modifier.padding(16.dp)
                )
            }

        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun PlayerUi(
    modifier: Modifier = Modifier,
    isPlay: Boolean = false,
    onPlayClick: () -> Unit = {},
    onNextClick: () -> Unit = {},
    onPreviousClick: () -> Unit = {}
) {


    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {


        IconButton(onClick = onNextClick) {

            Icon(
                imageVector = Icons.Rounded.SkipNext,
                contentDescription = ""
            )


        }
        IconButton(onClick = onPlayClick) {

            Icon(
                imageVector = if (isPlay) Icons.Rounded.Pause else Icons.Rounded.PlayArrow,
                contentDescription = ""
            )

        }

        IconButton(onClick = onPreviousClick) {

            Icon(
                imageVector = Icons.Rounded.SkipPrevious,
                contentDescription = ""
            )

        }

    }

}





