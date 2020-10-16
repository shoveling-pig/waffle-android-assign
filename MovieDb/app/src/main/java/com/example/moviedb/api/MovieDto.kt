package com.example.moviedb.api

data class Movie(
    val id: Long,
    val title: String,
    val poster_path: String?,
    val backdrop_path: String?,
    val overview: String
)

data class DiscoverResponse(
    val page: Long,
    val total_results: Long,
    val results: List<Movie>
)