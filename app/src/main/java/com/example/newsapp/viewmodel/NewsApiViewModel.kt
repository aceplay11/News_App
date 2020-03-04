package com.example.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.model.newsapiresponse.NewsApiResponse
import com.example.newsapp.model.remote.CallBack
import com.example.newsapp.model.remote.DataSource
import com.example.newsapp.model.repo.NewsRepo

class NewsApiViewModel(private val dataSource: DataSource) : ViewModel() {

    private val _newsFeed = MutableLiveData<NewsApiResponse>()

    val newsFeed: LiveData<NewsApiResponse> = _newsFeed

   fun loadNews(){
        dataSource.getNews(object : CallBack<NewsApiResponse>{
            override fun onNewsResponseResults(result: NewsApiResponse) {
                _newsFeed.value = result
            }

            override fun onError(error: String) {
            }

        })
    }

    fun getNewsRepo(): LiveData<NewsApiResponse>{
        return newsFeed
    }
}