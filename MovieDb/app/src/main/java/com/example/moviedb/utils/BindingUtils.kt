package com.example.moviedb.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedb.R
import com.example.moviedb.api.Movie
import com.example.moviedb.ui.main.MovieListAdapter

@BindingAdapter("adapter")
fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("items")
fun bindItems(view: RecyclerView, movie: List<Movie>?) {
    val adapter = view.adapter as? MovieListAdapter
    if (movie != null) {
        adapter?.setItems(movie)
    }
}

@BindingAdapter("setImageUrl")
fun bindImageUrl(view: ImageView, url: String?) {
    Glide.with(view.context)
        .load("https://image.tmdb.org/t/p/w500/${url}")
        .placeholder(R.drawable.ic_baseline_local_movies_24)
        .into(view)
}