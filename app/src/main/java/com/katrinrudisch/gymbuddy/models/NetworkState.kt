package com.katrinrudisch.gymbuddy.models

sealed class NetworkState<T> {
    class Loading<T> : NetworkState<T>()
    data class Success<T>(val data: T) : NetworkState<T>()
    class Empty<T> : NetworkState<T>()
    data class Error<T>(val errorMessage: String) : NetworkState<T>()
}