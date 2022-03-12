package com.katrinrudisch.gymbuddy.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.katrinrudisch.gymbuddy.compose.GymBuddyTheme
import com.katrinrudisch.gymbuddy.models.Plan
import com.katrinrudisch.gymbuddy.ui.components.Cell
import com.katrinrudisch.gymbuddy.ui.components.StatefulLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymBuddyTheme {
                PlansList()
            }
        }
    }

    @Composable
    fun PlansList() {
        val state = viewModel.planState.value
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            StatefulLayout(state) { data ->
                LazyColumn {
                    data.forEach {
                        item {
                            Cell(it.title, "")
                        }
                    }
                }
            }

            FloatingActionButton(onClick = { viewModel.addPlan(Plan(title = "Some plan")) }) {

            }
        }
    }
}