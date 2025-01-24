package com.player.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.player.presentation.R

@Composable
fun ProfileComp(modifier: Modifier = Modifier, title: String, subtitle: String) {

    Surface(shape = MaterialTheme.shapes.medium, modifier = modifier,
        onClick = {

    }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(R.drawable.logo),
                contentDescription = "",
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .size(50.dp)
                    .background(color = MaterialTheme.colorScheme.primary)
                    .padding(6.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {

                Text(
                    title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(subtitle, style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Normal)
            }

        }
    }


}


@Preview
@Composable
private fun PreviewProfileComp() {
    ProfileComp(title = "Playlist", subtitle = "Lorem Ipsum is simply dummy text",)
}














