package com.example.newsapp.model.remote

import com.example.newsapp.model.newsapiresponse.NewsApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewApiService {
    @GET(PATH)
    fun getNewsFeed(@Query("country") country: String = COUNTRY,
    @Query("apiKey") apiKey: String = API_KEY): Call <NewsApiResponse>

}
