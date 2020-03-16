package com.example.newsapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NewsSource {
    @Expose
    val id: String? = null

    @SerializedName("name")
    @Expose
    val name: String? = null

}