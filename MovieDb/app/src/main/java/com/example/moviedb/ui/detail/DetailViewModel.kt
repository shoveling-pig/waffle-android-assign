package com.example.moviedb.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviedb.api.Movie
import com.example.moviedb.repository.MovieRepository

class DetailViewModel(private val repository: MovieRepository): ViewModel() {
    val imgUrl: MutableLiveData<String> = MutableLiveData()
    val title: MutableLiveData<String> = MutableLiveData()
    val description: MutableLiveData<String> = MutableLiveData()

    fun setMovie(id: Long) {
        val movie = repository.getMovieById(id)
        imgUrl.value = movie.value?.backdrop_path
        title.value = movie.value?.title
        description.value = movie.value?.overview
    }
}