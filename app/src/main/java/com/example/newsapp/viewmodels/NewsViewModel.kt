package com.example.newsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.model.NewsResponse
import com.example.newsapp.networking.NewsRepository

class NewsViewModel : ViewModel() {
    private var mutableLiveData: MutableLiveData<NewsResponse?>? = null
    var newsRepository: NewsRepository? = null
    fun init() {
        if (mutableLiveData != null) {
            return
        }
        newsRepository = NewsRepository.instance
        mutableLiveData = newsRepository!!.getNews("us", "bb3f9d4541604888bbcf194129fb7c93")
    }

    fun getNewsRepository(): LiveData<NewsResponse?>? {
        return mutableLiveData
    }
}