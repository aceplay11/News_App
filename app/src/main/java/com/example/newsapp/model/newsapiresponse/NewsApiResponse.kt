package com.example.newsapp.model.newsapiresponse


import com.google.gson.annotations.SerializedName


data class NewsApiResponse(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<ArticlesItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)