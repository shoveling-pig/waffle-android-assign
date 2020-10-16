package com.example.moviedb.ui.main

import com.example.moviedb.api.Movie

interface OnMovieItemClickListener {
    fun onItemClick(movie: Movie)
}