package com.katrinrudisch.gymbuddy.compose

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val lightColors = lightColors(
    primary = blue,
    primaryVariant = darkBlue,
    secondary = darkBlue,
)

private val darkColors = darkColors(

)

object GymBuddyTheme {

    val dimens: Dimens
        @Composable
        get() = Dimens()

}

@Composable
fun GymBuddyTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = if (isSystemInDarkTheme()) darkColors else lightColors,
        content = content
    )

}