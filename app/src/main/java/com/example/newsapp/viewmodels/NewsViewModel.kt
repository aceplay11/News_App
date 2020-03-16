package com.example.newsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.model.NewsResponse
import com.example.newsapp.networking.NewsRepository

class NewsViewModel : ViewModel() {
    private var urlMutableLiveData: MutableLiveData<NewsResponse?>? = null
    val urlLiveData: LiveData<NewsResponse?>?
        get() = urlMutableLiveData
    var newsRepository: NewsRepository? = null
    fun init() {
        if (urlLiveData != null) {
            return
        }
        newsRepository = NewsRepository.instance
        urlMutableLiveData = newsRepository!!.getNews(source, apiKey )
    }

    fun getNewsRepository(): LiveData<NewsResponse?>? {
        return urlLiveData
    }
    companion object Constants{
        val apiKey = "bb3f9d4541604888bbcf194129fb7c93"
        val source = "us"

    }
}
