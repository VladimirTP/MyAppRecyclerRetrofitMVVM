package com.example.myapprecyclerretrofitmvvm.domain

import com.example.myapprecyclerretrofitmvvm.domain.models.NewsData

interface NewsRepository {

    suspend fun getListNewsData(): List<NewsData>
}