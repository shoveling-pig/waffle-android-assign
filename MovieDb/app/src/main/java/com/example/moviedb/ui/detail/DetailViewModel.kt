package com.example.moviedb.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviedb.api.Movie
import com.example.moviedb.repository.MovieRepository

class DetailViewModel(private val repository: MovieRepository): ViewModel() {
    var imgUrl: String? = ""
    var title: String? = ""
    var description: String? = ""

    fun setMovie(id: Long) {
        val movie = repository.getMovieById(id)
        imgUrl = movie.value?.backdrop_path
        title = movie.value?.title
        description = movie.value?.overview
    }
}