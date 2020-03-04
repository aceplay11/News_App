package com.example.newsapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.model.newsapiresponse.NewsApiResponse


class NewsFeedViewAdapter(private var response: NewsApiResponse):
    RecyclerView.Adapter<NewsFeedViewAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val authorTextView : TextView = view.findViewById(R.id.authorTextView)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val sourceTextView: TextView = view.findViewById(R.id.sourceTextView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_feed_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return response.articles!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = response.articles?.get(position)

        Glide.with(holder.imageView.context).load(news?.urlToImage).into(holder.imageView)
        holder.authorTextView.text = news?.author.toString()
        holder.titleTextView.text = news?.title
        holder.sourceTextView.text = news?.source.toString()
    }
    fun updateResponse(update: NewsApiResponse){
        response = update
        notifyDataSetChanged()
    }

}