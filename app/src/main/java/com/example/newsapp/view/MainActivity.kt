package com.example.newsapp.view

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.model.newsapiresponse.NewsApiResponse
import com.example.newsapp.model.repo.NewsRepo
import com.example.newsapp.viewmodel.NewsApiViewModel
import com.example.newsapp.viewmodel.vFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var dataSource = NewsRepo()
    private lateinit var viewModel: NewsApiViewModel
    private lateinit var adapter: NewsFeedViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        setupRecyclerView()

        textView.setOnClickListener {
            val website: String = "https://newsapi.org/"

            var url = Intent(Intent.ACTION_VIEW, Uri.parse(website))
            startActivity(url)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadNews()
        setupRecyclerView()
    }
    private fun setupViewModel(){
       viewModel = ViewModelProvider(this, vFactory.provideViewModelFactory()).get(NewsApiViewModel::class.java)
        viewModel.loadNews()
        viewModel.getNewsRepo().observe(this, renderNews)

    }
    private val renderNews = Observer<NewsApiResponse> { adapter.updateResponse(it) }

    fun setupRecyclerView(){
        if (viewModel.newsFeed.value != null) {
            adapter = NewsFeedViewAdapter(viewModel.getNewsRepo().value!!)
            newsFeedView.layoutManager = LinearLayoutManager(this)
            newsFeedView.adapter = adapter
        }
    }

}
