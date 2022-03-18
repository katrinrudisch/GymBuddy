package com.katrinrudisch.gymbuddy.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.katrinrudisch.gymbuddy.compose.GymBuddyTheme
import com.katrinrudisch.gymbuddy.models.NetworkState
import com.katrinrudisch.gymbuddy.models.Plan
import com.katrinrudisch.gymbuddy.ui.components.Cell
import com.katrinrudisch.gymbuddy.ui.components.StatefulLayout

@Composable
fun MainScreen(
    planState: NetworkState<List<Plan>>,
    onAddActionClicked: () -> Unit,
    onCellClicked: () -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Gym Buddy") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddActionClicked) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "")
            }
        }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            StatefulLayout(planState) { data ->
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

@Composable
@Preview
fun MainScreenPreview() {
    val plans = listOf(
        Plan(title = "Some plan"),
        Plan(title = "Another plan")
    )
    GymBuddyTheme {
        MainScreen(
            planState = NetworkState.Success(plans),
            onAddActionClicked = {},
            onCellClicked = {}
        )
    }
}