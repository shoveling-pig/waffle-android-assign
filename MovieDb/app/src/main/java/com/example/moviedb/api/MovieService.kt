package com.example.moviedb.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("discover/movie")
    fun fetchDiscoverMovie(@Query("api_key") api_key: String, @Query("page") page: Int, @Query("sort_by") sort_by: String) : Single<DiscoverResponse>

}