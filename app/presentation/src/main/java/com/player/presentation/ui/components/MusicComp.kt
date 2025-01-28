package com.player.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.player.presentation.R
import com.player.presentation.ui.theme.NexusMusicTheme

@Composable
fun MusicComp(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    isFavorite: Boolean = false,
    isPlay: Boolean = false,
    fav: () -> Unit,
    play: () -> Unit,
    menu: () -> Unit
) {


    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.live_thum),
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                contentDescription = "", contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.padding(horizontal = 6.dp))
            Column {

                Text(
                    title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    subtitle,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Normal
                )

            }
        }


        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = play) {
                Icon(
                    painter = painterResource(if (isPlay) R.drawable.pause_icon else R.drawable.play_icon),
                    contentDescription = ""
                )
            }
            IconButton(onClick = fav) {
                Icon(
                    painter = painterResource(if (isFavorite) R.drawable.favorite_icon else R.drawable.favorite_outline_icon),
                    contentDescription = ""
                )
            }
            IconButton(onClick = menu) {
                Icon(
                    painter = painterResource(R.drawable.more_vert_24),
                    contentDescription = ""
                )
            }
        }


    }

}


@Preview(showBackground = true)
@Composable
private fun PrevMusicComp() {


    NexusMusicTheme {

        Surface {
            LazyColumn {

                items(10) {
                    var isFavorite by remember {
                        mutableStateOf(false)
                    }

                    var isPlaying by remember {
                        mutableStateOf(false)
                    }

                    MusicComp(
                        title = "Rain On Me",
                        subtitle = "Lady Gaga",
                        play = { isPlaying = !isPlaying },
                        fav = { isFavorite = !isFavorite },
                        menu = {},
                        modifier = Modifier.padding(6.dp),
                        isFavorite = isFavorite,
                        isPlay = isPlaying
                    )
                    HorizontalDivider()
                }
            }

        }
    }

}





