package com.player.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.player.presentation.R


@Composable
fun SliderComponent(modifier: Modifier = Modifier, image: Int, title: String, description: String) {
    Column(modifier = modifier) {
        Image(
            painter = painterResource(image),
            contentDescription = "",
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.large), contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold, maxLines = 2
        )

        Text(
            text = description,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Normal, maxLines = 3
        )

    }

}


@Preview(showBackground = true)
@Composable
private fun PrevLowerThird() {
    SliderComponent(
        image = R.drawable.live_thum, title = "Lorem Ipsum is simply dummy",
        description = "Lorem Ipsum is simply dummy text of the \n" +
                "printing and typesetting industry. Lorem\n" +
                " Ipsum has been", modifier = Modifier.padding(16.dp)
    )
}