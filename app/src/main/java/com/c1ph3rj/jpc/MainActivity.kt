package com.c1ph3rj.jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.c1ph3rj.jpc.constants.CustomColors
import com.c1ph3rj.jpc.constants.fontFamily
import com.c1ph3rj.jpc.ui.theme.JpcTheme
import com.c1ph3rj.jpc.ui.theme.LightWhite

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpcTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = Color.White,
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var expandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(targetValue = if(expandedState) 180f else 0f)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing,
                    )
                )
                .background(LightWhite)
                .padding(10.dp),
            elevation = 10.dp,
            shape = RoundedCornerShape(10.dp),
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "MIUI 14 Launched",
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = fontFamily,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                    IconButton(onClick = {
                        expandedState = !expandedState
                        print(expandedState)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = "Arrow",
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                                .rotate(rotationState)
                        )
                    }
                }
                if (expandedState){
                    Text("The company will roll out the MIUI 14 update in Mi 10T Pro, Mi 10T, Redmi Note 11 Pro 5G, Redmi Note 12 5G, Redmi Note 11S, Redmi Note 11T 5G, Redmi 10 Prime 2022, Redmi 10 Prime, Redmi Note 11 and Redmi 10 in Q3 2023.",
                    style = MaterialTheme.typography.subtitle1,
                    fontFamily = fontFamily,
                    modifier = Modifier.padding(10.dp))
                }
            }
        }
        Card(modifier = Modifier.padding(20.dp),
        backgroundColor = LightWhite){
            GoogleSignUpBtn()
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JpcTheme {
        Greeting()
    }
}