package com.example.newsapp.model.repo

import com.example.newsapp.model.newsapiresponse.NewsApiResponse
import com.example.newsapp.model.remote.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepo() :DataSource {

    private var call: Call<NewsApiResponse>? = null
    override fun getNews(callBack: CallBack<NewsApiResponse>) {
        call = RetrofitHelper().getNewsApiService().getNewsFeed()
        call?.enqueue(object :Callback<NewsApiResponse>{
            override fun onFailure(call: Call<NewsApiResponse>, t: Throwable) {
                callBack.onError(t.message.toString())
            }

            override fun onResponse(
                call: Call<NewsApiResponse>,
                response: Response<NewsApiResponse>) {
                response?.body()?.let {
                    if (response.isSuccessful ){
                        callBack.onNewsResponseResults(it)
                    } else{
                        callBack.onError(it.status.toString())
                    }
                }

            }

        })
    }

}