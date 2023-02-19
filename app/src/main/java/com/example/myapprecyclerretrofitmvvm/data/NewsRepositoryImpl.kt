package com.example.myapprecyclerretrofitmvvm.data

import com.example.myapprecyclerretrofitmvvm.data.mappers.NewsMapper
import com.example.myapprecyclerretrofitmvvm.data.network.NewsService
import com.example.myapprecyclerretrofitmvvm.domain.models.NewsData
import com.example.myapprecyclerretrofitmvvm.domain.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val mapper: NewsMapper,
    private val service: NewsService
) : NewsRepository {

    override suspend fun getListNewsData(): List<NewsData> {
        return withContext(Dispatchers.IO) {
            service.getNews("wsj.com").execute().body()?.articles?.map { mapper(it) }
                ?: throw Exception()
        }
    }
}