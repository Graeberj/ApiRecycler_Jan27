package com.example.apirecycler_jan27.model.network

import com.example.apirecycler_jan27.model.network.models.Todo
import retrofit2.Response
import retrofit2.http.GET

interface TodoService {

    @GET("todos")
    suspend fun getTodos(): Response<List<Todo>>
}