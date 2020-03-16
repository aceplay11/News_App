package com.example.newsapp.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapters.NewsAdapter
import com.example.newsapp.model.NewsArticle
import com.example.newsapp.model.NewsResponse
import com.example.newsapp.viewmodels.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var articleArrayList = ArrayList<NewsArticle?>()
    var newsAdapter: NewsAdapter? = null
    var newsViewModel: NewsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupRecyclerView()

        textView.setOnClickListener {
            val website = "https://newsapi.org"
            val url = Intent(Intent.ACTION_VIEW, Uri.parse(website))
            startActivity(url)
        }
    }

    private fun setupViewModel(){
        newsViewModel =  ViewModelProvider(this).get(NewsViewModel::class.java)
        newsViewModel!!.init()
        newsViewModel!!.getNewsRepository()!!.observe(this, Observer { newsResponse: NewsResponse? ->
            val newsArticles = newsResponse?.articles
            articleArrayList.addAll(newsArticles!!)
            newsAdapter!!.notifyDataSetChanged()
        })
    }

    private fun setupRecyclerView() {
        if (newsAdapter == null) {
            newsAdapter = NewsAdapter( articleArrayList)
        }
        newsFeedView.layoutManager = LinearLayoutManager(this)
        newsFeedView.addItemDecoration(DividerItemDecoration(this,
            LinearLayoutManager.VERTICAL))
        newsFeedView.adapter = newsAdapter

    }
}
