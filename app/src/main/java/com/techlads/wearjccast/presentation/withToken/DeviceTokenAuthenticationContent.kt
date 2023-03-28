package com.techlads.wearjccast.presentation.withToken

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.github.alexzhirkevich.customqrgenerator.QrData
import com.github.alexzhirkevich.customqrgenerator.vector.QrCodeDrawable
import com.github.alexzhirkevich.customqrgenerator.vector.QrVectorOptions
import com.github.alexzhirkevich.customqrgenerator.vector.style.*

@Composable
fun DeviceTokenAuthenticationContent(
    token: String,
    url: String,
    onLoginClick: (token: String) -> Unit
) {
    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val globalText = "Scan to login"

        Text(
            modifier = Modifier.padding(8.dp),
            text = globalText,
            style = MaterialTheme.typography.title3
        )

        val white = QrVectorColor.Solid(
            android.graphics.Color.LTGRAY
        )
        val qrCodeView = QrCodeDrawable(
            context,
            QrData.Url(url), QrVectorOptions.Builder().setColors(
                colors = QrVectorColors(
                    ball = white,
                    frame = white,
                    dark = white
                )
            ).build()
        )

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .clickable {
                    onLoginClick("abc")
                },
            bitmap = qrCodeView.toBitmap(200, 200).asImageBitmap(),
            contentDescription = "QR Code for URL $url"
        )

    }
}

@Preview
@Composable
fun DeviceTokenAuthenticationContentPrev() {
    DeviceTokenAuthenticationContent("abc", "www.home.com") {

    }
}