package com.androiddevs.mvvmnewsapp.api

import com.example.wise.model.CrytoResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIinterface {

    @GET("api/markets")
    suspend fun getalldata(): CrytoResponse


}