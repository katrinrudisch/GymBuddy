package com.katrinrudisch.gymbuddy.repository

import com.katrinrudisch.gymbuddy.service.ApiService

class ResponseRepository (private val api: ApiService) {
    suspend fun getResponse() = api.getResponse()
}