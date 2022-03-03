package com.katrinrudisch.gymbuddy.service

import com.katrinrudisch.gymbuddy.models.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/data")
    suspend fun getResponse(): Response
}