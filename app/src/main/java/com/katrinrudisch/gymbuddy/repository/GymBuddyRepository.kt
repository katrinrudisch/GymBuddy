package com.katrinrudisch.gymbuddy.repository

import com.katrinrudisch.gymbuddy.models.NetworkState
import com.katrinrudisch.gymbuddy.models.Plan
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GymBuddyRepository(private val planDao: PlanDao) {

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    private val _plansState = MutableStateFlow<NetworkState<List<Plan>>>(NetworkState.Empty())
    val planState = _plansState

    fun savePlan(plan: Plan){
        scope.launch {
            planDao.insert(plan)
            loadPlans()
        }
    }

    fun loadPlans() {
        _plansState.tryEmit(NetworkState.Loading())
        scope.launch {
            try {
                val plans = planDao.getAll()
               _plansState.tryEmit(NetworkState.Success(plans))
            } catch (e: Throwable) {
                _plansState.tryEmit(NetworkState.Error("Some error happened"))
            }
        }
    }
}