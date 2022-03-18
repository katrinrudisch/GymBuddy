package com.katrinrudisch.gymbuddy.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.katrinrudisch.gymbuddy.ui.components.Cell
import com.katrinrudisch.gymbuddy.ui.components.StatefulLayout

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onAddActionClicked: () -> Unit,
    onCellClicked: () -> Unit
) {
    val state = viewModel.planState.value
    Scaffold(
        topBar = { TopAppBar(title = { Text("Gym Buddy") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddActionClicked) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            StatefulLayout(state) { data ->
                LazyColumn {
                    data.forEach {
                        item {
                            Cell(it.title, "") { onCellClicked() }
                            Divider()
                        }
                    }
                }
            }
        }
    }
}