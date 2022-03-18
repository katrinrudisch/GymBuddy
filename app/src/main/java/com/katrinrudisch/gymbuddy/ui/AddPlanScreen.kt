package com.katrinrudisch.gymbuddy.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import com.katrinrudisch.gymbuddy.models.Plan

@Composable
fun AddPlanScreen(
    viewModel: MainViewModel,
    onBackPressed: () -> Unit
) {
    BackHandler(onBack = onBackPressed)
    Scaffold(
        topBar = { TopAppBar(title = { Text("Add a new Plan") }) },
    ) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        Column {
            TextField(
                value = textState.value,
                onValueChange = { textState.value = it }
            )
            Button(onClick = {
                viewModel.addPlan(Plan(title = textState.value.text))
                onBackPressed()
            }) {
                Text(text = "Save")
            }
        }
    }
}