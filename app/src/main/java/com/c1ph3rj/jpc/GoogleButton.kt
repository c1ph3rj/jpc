package com.c1ph3rj.jpc

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GoogleSignUpBtn() {
    var googleSignUpClicked by remember { mutableStateOf(false) }
    Surface(
        onClick = {
            googleSignUpClicked = !googleSignUpClicked
        },
        modifier = Modifier.padding(20.dp)
            .animateContentSize (
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
                    ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                12.dp,
                10.dp,
                16.dp,
                10.dp
            )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.google_ic),
                contentDescription = "Google Icon",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = if(googleSignUpClicked) "Creating Account ..." else "Sign Up With Google", style = MaterialTheme.typography.subtitle1)
            Spacer(modifier = Modifier.width(4.dp))
            if (googleSignUpClicked) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    color = MaterialTheme.colors.primary,
                    strokeWidth = 2.dp
                )
            }
        }
    }
}

@Preview
@Composable
fun previewBtn() {
    GoogleSignUpBtn()
}


