package com.katrinrudisch.gymbuddy.repository

import com.katrinrudisch.gymbuddy.models.NetworkState
import com.katrinrudisch.gymbuddy.models.Plan
import com.katrinrudisch.gymbuddy.service.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GymBuddyRepository(private val api: ApiService) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    private val _plansState = MutableStateFlow<NetworkState<List<Plan>>>(NetworkState.Empty())
    val planState = _plansState

    fun loadPlans() {
        _plansState.tryEmit(NetworkState.Loading())
        scope.launch {
            try {
                _plansState.tryEmit(NetworkState.Success(mockedPlans))
            } catch (e: Throwable) {
                _plansState.tryEmit(NetworkState.Error("Some error happened"))
            }
        }
    }

    private val mockedPlans = listOf(
        Plan(title = "Back and Bizeps"),
        Plan(title = "Chest and Trizeps"),
        Plan(title = "Butt and Legs"),
    )
}