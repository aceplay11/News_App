package com.example.newsapp.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.newsapp.adapters.NewsAdapter.NewsViewHolder
import com.example.newsapp.model.NewsArticle
import com.bumptech.glide.Glide
import com.example.newsapp.R
import java.util.*

class NewsAdapter(var context: Context, var articles: ArrayList<NewsArticle?>) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.titleTextView.text = articles[position]?.title.toString()
        holder.authorTextView.text = articles[position]?.author
        holder.sourceTextView.text = articles[position]?.url
        Glide.with(holder.imageView.context).load(articles[position]?.urlToImage).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    inner class NewsViewHolder(itemView: View) : ViewHolder(itemView) {
        var imageView: ImageView
        var authorTextView : TextView
        var titleTextView: TextView
        var sourceTextView: TextView

        init {
            imageView = itemView.findViewById(R.id.imageView)
            authorTextView  = itemView.findViewById(R.id.authorTextView)
            titleTextView = itemView.findViewById(R.id.titleTextView)
            sourceTextView = itemView.findViewById(R.id.sourceTextView)
            itemView.setOnClickListener {
                var url = Intent(Intent.ACTION_VIEW, Uri.parse(sourceTextView.text.toString()))
                startActivity(context, url, null)
            }
        }
    }

}