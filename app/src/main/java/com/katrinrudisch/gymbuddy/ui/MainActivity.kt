package com.katrinrudisch.gymbuddy.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.katrinrudisch.gymbuddy.compose.GymBuddyTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymBuddyTheme {
                GymBuddyScreen()
            }
        }
    }

    @Composable
    fun GymBuddyScreen() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Destination.MAIN.name
        ) {
            composable(Destination.MAIN.name) {
                MainScreen(
                    planState = viewModel.planState.value,
                    onAddActionClicked = { navController.navigate(Destination.ADD_PLAN.name) },
                    onCellClicked = { navController.navigate(Destination.DETAIL.name) }
                )
            }
            composable(Destination.ADD_PLAN.name) {
                AddPlanScreen(
                    onPlanAdded = { viewModel.addPlan(it) },
                    onBackPressed = { navController.navigateUp() }
                )
            }
            composable(Destination.DETAIL.name) {
                DetailScreen(onBackPressed = { navController.navigateUp() })
            }
        }
    }

    enum class Destination {
        MAIN,
        ADD_PLAN,
        DETAIL
    }

}