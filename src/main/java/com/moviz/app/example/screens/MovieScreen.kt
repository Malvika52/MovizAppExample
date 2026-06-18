package com.moviz.app.example.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.moviz.app.example.viewmodel.MovieViewModel
import com.moviz.app.example.viewmodel.MovieViewModelFactory

@Composable
fun Moviescreen(viewModel: MovieViewModel, navController: NavController){
    val movies = viewModel.movies.collectAsState()
    MovieList(
        movies.value,
        onMovieClick = { movie ->
            viewModel.selectMovie(movie)
            if(navController.currentDestination?.route == "list"){
                navController.navigate("detail")
            }

        }
    )
}