package com.player.presentation.screens.pages.starter

import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.player.presentation.R
import com.player.presentation.ui.components.ImageWithText


@Preview(showSystemUi = true)
@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        ImageWithText(image = R.drawable.logo, text = context.getString(R.string.app_name))
    }


}


