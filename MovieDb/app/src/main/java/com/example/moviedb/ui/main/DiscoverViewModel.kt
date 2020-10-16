package com.example.moviedb.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviedb.api.Movie
import com.example.moviedb.repository.MovieRepository

class DiscoverViewModel(private val repository: MovieRepository) : ViewModel() {
    var allMovies: LiveData<List<Movie>> = repository.getAllMovies()
}