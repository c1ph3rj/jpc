package com.c1ph3rj.jpc.constants

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.c1ph3rj.jpc.R

val fontFamily = FontFamily(
    fonts = listOf(
    Font(resId = R.font.josefin_sans_bold, weight = FontWeight.Bold),
    Font(resId = R.font.josefin_sans_italic, style = FontStyle.Italic),
    Font(resId = R.font.josefin_sans_light, weight = FontWeight.Light),
    Font(resId = R.font.josefin_sans_medium, weight = FontWeight.Medium),
    Font(resId = R.font.josefin_sans_regular, weight = FontWeight.Normal),
    Font(resId = R.font.josefin_sans_semibold, weight = FontWeight.SemiBold))
)