package com.moviz.app.example.retrofit


import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @GET("/")
    suspend fun getMovieList() : List<Movie>

}
