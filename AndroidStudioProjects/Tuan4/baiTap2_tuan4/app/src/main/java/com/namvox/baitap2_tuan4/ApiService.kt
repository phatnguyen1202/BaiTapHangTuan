package com.namvox.baitap2_tuan4


import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("tasks")
    suspend fun getTasks(): Response<List<Task>>

    @GET("tasks/{id}")
    suspend fun getTaskById(@Path("id") id: Int): Response<Task>

    @DELETE("tasks/{id}")
    suspend fun deleteTask(@Path("id") id: Int): Response<Unit>
}