package com.player.presentation.screens.pages.starter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.player.presentation.R
import com.player.presentation.screens.state.AppVM

@Composable
fun IntroScreens(viewmodel: AppVM) {

    val context = LocalContext.current

    val pagerState = rememberPagerState {
        viewmodel.getPagerData(context).size
    }
    val data by rememberUpdatedState(viewmodel.getPagerData(context)[pagerState.currentPage])

    Column(verticalArrangement = Arrangement.SpaceBetween) {
        HorizontalPager(pagerState, modifier = Modifier.fillMaxHeight(0.9f)) { item ->

            Column(modifier = Modifier.padding(16.dp)) {

                AsyncImage(
                    model = data.image,
                    contentDescription = "",
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.extraLarge)
                        .fillMaxHeight(0.6f),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    text = data.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = data.des,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal
                )

            }

        }

        PagerIndicator(pageCount = pagerState.pageCount, currentPageIndex = pagerState.currentPage)
    }


}

@Composable
fun PagerIndicator(pageCount: Int, currentPageIndex: Int, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pageCount) { iteration ->
                val color = if (currentPageIndex == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(16.dp)
                )
            }
        }
    }
}