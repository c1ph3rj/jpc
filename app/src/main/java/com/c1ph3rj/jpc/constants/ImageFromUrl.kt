package com.c1ph3rj.jpc.constants

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import java.lang.Float.min

@Composable
fun ImageFromUrl(Url: String, downloadableUrl: String) {
    val painter = rememberAsyncImagePainter(Url, contentScale = ContentScale.Crop)
    val state = painter.state
    val transition by animateFloatAsState(
        targetValue = if (state is AsyncImagePainter.State.Success) 1f else 0f
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(state = rememberScrollState())
                .fillMaxSize()
        ) {
            Image(
                painter = painter,
                contentDescription = "image Loaded From Url",
                modifier = Modifier
                    .height(200.dp)
                    .width(300.dp)
                    .scale(.8f + (.2f * transition))
                    .graphicsLayer { (1f - transition) * 5f }
                    .alpha(min(1f, transition / .2f))
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(10.dp))

            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(downloadableUrl)
                    .crossfade(true)
                    .networkCachePolicy(CachePolicy.ENABLED)
                    .diskCachePolicy(CachePolicy.DISABLED)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(200.dp)
                    .width(300.dp)
                    .scale(.8f + (.2f * transition))
                    .graphicsLayer { (1f - transition) * 5f }
                    .alpha(min(1f, transition / .2f))
                    .clip(RoundedCornerShape(10.dp)),
            )
        }
    }
}
