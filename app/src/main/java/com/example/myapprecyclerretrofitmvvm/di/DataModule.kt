package com.example.myapprecyclerretrofitmvvm.di

import com.example.myapprecyclerretrofitmvvm.data.NewsRepositoryImpl
import com.example.myapprecyclerretrofitmvvm.domain.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun getRepository(impl: NewsRepositoryImpl): NewsRepository
}