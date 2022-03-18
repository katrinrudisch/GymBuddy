package com.katrinrudisch.gymbuddy.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import com.katrinrudisch.gymbuddy.compose.GymBuddyTheme
import com.katrinrudisch.gymbuddy.models.Plan

@Composable
fun AddPlanScreen(
    onPlanAdded: (Plan) -> Unit,
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
            Button(
                onClick = {
                    onPlanAdded(Plan(title = textState.value.text))
                    onBackPressed()
                }
            ) {
                Text(text = "Save")
            }
        }
    }
}

@Composable
@Preview
fun AddPlanScreenPreview() {
    GymBuddyTheme {
        AddPlanScreen(onPlanAdded = {}, onBackPressed = {})
    }
}