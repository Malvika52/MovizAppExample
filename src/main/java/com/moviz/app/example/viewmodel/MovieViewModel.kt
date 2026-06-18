package com.moviz.app.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moviz.app.example.repository.MovieRepository
import com.moviz.app.example.retrofit.Movie
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository ) : ViewModel(){

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies : StateFlow<List<Movie>> = _movies

    private val _selectedMovie = MutableStateFlow<Movie?>(null)
    val selectedMovie : StateFlow<Movie?> = _selectedMovie

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            repository.getMovieList().collect {
                movies -> _movies.value = movies
            }
        }
    }

    fun selectMovie(movie: Movie){
        _selectedMovie.value = movie
    }

}