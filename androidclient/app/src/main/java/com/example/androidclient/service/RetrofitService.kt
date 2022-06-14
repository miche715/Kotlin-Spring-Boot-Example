package com.example.androidclient.service

import com.example.androidclient.model.ToDoDTO
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService
{
    @GET("api/todo/all")
    fun getAll(): Call<MutableList<ToDoDTO>>
}