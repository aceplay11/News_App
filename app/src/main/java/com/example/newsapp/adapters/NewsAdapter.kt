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
import kotlinx.android.synthetic.main.news_item.*
import kotlinx.android.synthetic.main.news_item.view.*

class NewsAdapter(var articles: ArrayList<NewsArticle?>) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
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
        val imageView: ImageView = itemView.imageView
        var authorTextView : TextView = itemView.authorTextView
        var titleTextView: TextView = itemView.titleTextView
        var sourceTextView: TextView = itemView.sourceTextView

//            //evenbtus
//            itemView.setOnClickListener {
//                var url = Intent(Intent.ACTION_VIEW, Uri.parse(sourceTextView.text.toString()))
//                startActivity(context, url, null)
            }

    }

