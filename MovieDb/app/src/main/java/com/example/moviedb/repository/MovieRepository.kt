package com.example.moviedb.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviedb.BuildConfig
import com.example.moviedb.api.DiscoverResponse
import com.example.moviedb.api.Movie
import com.example.moviedb.api.MovieService
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io

class MovieRepository(private val service: MovieService) {
    private val movieList: MutableLiveData<List<Movie>> = MutableLiveData()
    private val movie: MutableLiveData<Movie> = MutableLiveData()

    init {
        val response = service.fetchDiscoverMovie(BuildConfig.TMDB_API_KEY, 1, "popularity.desc")

        response
            .subscribeOn(Schedulers.io())
            .subscribe { response ->
                movieList.postValue(response.results)
            }
    }

    fun getAllMovies(): LiveData<List<Movie>> = movieList

    fun getMovieById(id: Long): LiveData<Movie> {
        movieList.value?.forEach {
            if (it.id == id) {
                movie.value = it
            }
        }
        return movie
    }

}