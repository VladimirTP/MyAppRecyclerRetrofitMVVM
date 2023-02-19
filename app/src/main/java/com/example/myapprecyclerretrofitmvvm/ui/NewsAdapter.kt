package com.example.myapprecyclerretrofitmvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapprecyclerretrofitmvvm.R
import com.example.myapprecyclerretrofitmvvm.domain.models.NewsData

class NewsAdapter(private val listNewsData: List<NewsData>) :
    RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = listNewsData.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.onBind(listNewsData[position])
    }
}