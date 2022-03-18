package com.katrinrudisch.gymbuddy.ui

import androidx.activity.compose.BackHandler
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen(onBackPressed: () -> Unit) {
    BackHandler(onBack = onBackPressed)
    Scaffold(
        topBar = { TopAppBar(title = { Text("Plan detail") }) },
    ) {

    }
}