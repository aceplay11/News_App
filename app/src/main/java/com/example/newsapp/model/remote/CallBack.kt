package com.example.newsapp.model.remote

import com.example.newsapp.model.newsapiresponse.NewsApiResponse

interface CallBack<T> {
    fun onNewsResponseResults(result: T)
    fun onError(error: String)
}

interface DataSource{
    fun getNews(callBack: CallBack<NewsApiResponse>)
}