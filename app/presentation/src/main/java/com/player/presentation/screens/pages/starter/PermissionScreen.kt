package com.player.presentation.screens.pages.starter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.player.presentation.R


@Preview(showSystemUi = true)
@Composable
fun PermissionScreen(modifier: Modifier = Modifier) {


    Column(modifier = Modifier.padding(16.dp).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {

        Column {

            PermissionItem(icon = R.drawable.play_icon)
            PermissionItem(icon = R.drawable.play_icon)
            PermissionItem(icon = R.drawable.play_icon)
        }

        OutlinedButton(
            onClick = {},
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(0.8f)
                ,
            shape = MaterialTheme.shapes.small
        ) {
            Text("Done")
        }

    }

}

@Composable
fun PermissionItem(modifier: Modifier = Modifier, icon: Int) {


    Surface(
        shape = MaterialTheme.shapes.medium, modifier = Modifier
            .padding(4.dp), tonalElevation = 3.dp
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {

            AsyncImage(model = icon, contentDescription = "", modifier = Modifier.size(50.dp))
            Spacer(modifier = Modifier.padding(8.dp))
            Column {
                Text("Permission Title", style = MaterialTheme.typography.titleMedium)
                Text("Permission Description", style = MaterialTheme.typography.bodySmall)
            }
        }

    }

}