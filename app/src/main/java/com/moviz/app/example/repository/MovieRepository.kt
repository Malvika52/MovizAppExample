package com.moviz.app.example.repository

import com.moviz.app.example.retrofit.Movie
import com.moviz.app.example.retrofit.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepository {
    private val apiService = RetrofitInstance.apiService

    suspend fun getMovieList(): Flow<List<Movie>> = flow {
        val movieList = apiService.getMovieList()
        emit(movieList)
    }

}
