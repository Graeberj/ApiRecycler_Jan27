package com.example.apirecycler_jan27.model.network

class ApiManager {

    private var todoService: TodoService =
        RetroFitInstance.providesRetrofit().create(TodoService::class.java)

    suspend fun getTodos() = todoService.getTodos()
}