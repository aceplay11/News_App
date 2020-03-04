package com.example.newsapp.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.model.remote.DataSource
import com.example.newsapp.model.repo.NewsRepo

object vFactory {
    private val dataSource: DataSource = NewsRepo()
    private val viewModelFactory = ViewModelFactory(dataSource)

    fun provideRepo(): DataSource{
        return dataSource
    }

    fun provideViewModelFactory(): ViewModelProvider.Factory{
        return viewModelFactory
    }
}