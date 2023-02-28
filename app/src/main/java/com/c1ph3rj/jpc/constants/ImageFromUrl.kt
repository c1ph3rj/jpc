package com.c1ph3rj.jpc.constants

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.decode.DataSource

@Composable
fun ImageFromUrl(Url : String) {
    Box(modifier = Modifier
        .padding(10.dp)
        .size(300.dp)){
        val painter = rememberAsyncImagePainter(
            model = Url,
        )
        val state = painter.state
        if (state is AsyncImagePainter.State.Success) {
            // Perform the transition animation.
        }
    }
}