package com.katrinrudisch.gymbuddy.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katrinrudisch.gymbuddy.models.NetworkState
import com.katrinrudisch.gymbuddy.models.Plan
import com.katrinrudisch.gymbuddy.repository.GymBuddyRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel(private val repo: GymBuddyRepository) : ViewModel() {

    val planState = mutableStateOf<NetworkState<List<Plan>>>(NetworkState.Empty())

    init {
        repo.loadPlans()
        observePlanState()
    }

    internal fun reloadPlans() {
        repo.loadPlans()
    }

    internal fun addPlan(plan: Plan) {
        repo.savePlan(plan)
    }

    private fun observePlanState() {
        repo.planState.onEach {
            planState.value = it
        }.launchIn(viewModelScope)
    }


}

