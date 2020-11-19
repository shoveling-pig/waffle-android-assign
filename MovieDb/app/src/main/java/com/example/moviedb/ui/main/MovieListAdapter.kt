package com.example.moviedb.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedb.api.Movie
import com.example.moviedb.databinding.ItemDiscoverMovieBinding

class MovieListAdapter(val listener: (Movie) -> Unit) : RecyclerView.Adapter<MovieViewHolder>() {
    private val items = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemDiscoverMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = items[position]
        holder.bindMovie(item)
        holder.itemView.setOnClickListener{
            listener(item)
        }
    }

    fun setItems(movies: List<Movie>) {
        items.clear()
        items.addAll(movies)
        notifyDataSetChanged()
    }

}

class MovieViewHolder(private val binding: ItemDiscoverMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bindMovie(movie: Movie) {
        binding.item = movie
    }

}