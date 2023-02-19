package com.example.myapprecyclerretrofitmvvm.data.network

import com.example.myapprecyclerretrofitmvvm.data.models.NewsListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsService {

    @Headers("x-api-key: 14ed4d040b4747a5907ab94abfbe7813")
    @GET("everything")
    fun getNews(@Query("domains") domain: String): Call<NewsListResponse>
}