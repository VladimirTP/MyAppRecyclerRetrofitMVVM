package com.example.myapprecyclerretrofitmvvm.data.mappers

import com.example.myapprecyclerretrofitmvvm.data.models.NewsResponse
import com.example.myapprecyclerretrofitmvvm.domain.models.NewsData
import javax.inject.Inject

class NewsMapper @Inject constructor() {

    operator fun invoke(response: NewsResponse): NewsData = with(response) {
        return NewsData(
            author = author.orEmpty(),
            title = title.orEmpty(),
            url = url.orEmpty(),
            urlToImage = urlToImage.orEmpty()
        )
    }
}