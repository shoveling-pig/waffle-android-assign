package com.example.moviedb.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviedb.api.DiscoverResponse
import com.example.moviedb.api.Movie
import com.example.moviedb.api.MovieService
import io.reactivex.rxjava3.core.Single

class MovieRepository(private val service: MovieService) {
    private val response: Single<DiscoverResponse> = service.fetchDiscoverMovie(1, "desc")
    private var items: List<Movie> = mutableListOf()

    val movieList: MutableLiveData<List<Movie>> by lazy { MutableLiveData<List<Movie>>() }
    val movie: MutableLiveData<Movie> by lazy { MutableLiveData<Movie>() }

    init {
        response.subscribe { response->
            items = response.results
        }
    }

    fun getAllMovies(): LiveData<List<Movie>> {
        movieList.value = items
        return movieList
    }

    fun getMovieById(id: Long): LiveData<Movie> {
        items.forEach {
            if (it.id == id) {
                movie.value = it
            }
        }
        return movie
    }

}