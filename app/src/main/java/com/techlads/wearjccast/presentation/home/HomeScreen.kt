package com.techlads.wearjccast.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.ScalingLazyColumn
import com.techlads.wearjccast.R
import com.techlads.wearjccast.presentation.home.data.Movie

@Composable
fun HomeScreen() {
    ScalingLazyColumn {
        items(20) {
            MovieItem(payload = Movie("Movie $it", "url", R.drawable.a_6))
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun HomeScreenPrev() {
    HomeScreen()
}