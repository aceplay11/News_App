package com.example.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.model.remote.DataSource
import com.example.newsapp.model.repo.NewsRepo

class ViewModelFactory(private val repo: DataSource): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsApiViewModel(repo) as T
    }
}