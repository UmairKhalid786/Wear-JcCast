package com.techlads.wearjccast.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.techlads.wearjccast.R
import com.techlads.wearjccast.presentation.home.data.Movie

@Composable
fun MovieItem(payload: Movie) {
    Box(
        Modifier
            .padding(horizontal = 52.dp)
            .background(MaterialTheme.colors.background, MaterialTheme.shapes.medium)
            .aspectRatio(0.6f)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = payload.drawableRes),
            contentDescription = payload.title,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = payload.title,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
                    .padding(vertical = 16.dp, horizontal = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun MovieItemPreview() {
    MovieItem(payload = Movie("Movie", "", R.drawable.a_6))
}