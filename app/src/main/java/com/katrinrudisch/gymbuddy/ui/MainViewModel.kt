package com.katrinrudisch.gymbuddy.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.katrinrudisch.gymbuddy.repository.ResponseRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repo: ResponseRepository) : ViewModel() {

    fun loadData() {
        viewModelScope.launch {
            try {
                val response = repo.getResponse()
                println("Response: $response")
            } catch (e: Throwable) {
                println("Error happened: $e")
            }
        }
    }
}