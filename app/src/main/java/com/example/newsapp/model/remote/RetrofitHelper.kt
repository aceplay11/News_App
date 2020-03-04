package com.example.newsapp.model.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://newsapi.org/v2/"
const val PATH = "top-headlines"
const val COUNTRY = "us"
const val API_KEY = "bb3f9d4541604888bbcf194129fb7c93"
class RetrofitHelper {

    private fun getRetrofitInstance(): Retrofit {

        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getNewsApiService(): NewApiService{
        return getRetrofitInstance().create(NewApiService::class.java)
    }

}