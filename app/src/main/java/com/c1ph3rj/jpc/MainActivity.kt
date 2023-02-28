package com.c1ph3rj.jpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
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
                        text = "My Title",
                        style = MaterialTheme.typography.h5,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        fontFamily = fontFamily,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = "Arrow",
                            modifier = Modifier
                                .height(30.dp)
                                .width(30.dp)
                        )
                    }
                }
                Row {

                }
            }
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