package com.moviz.app.example.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.moviz.app.example.retrofit.Movie

@Composable
fun MovieList(movies: List<Movie>, onMovieClick : (Movie)-> Unit){

    LazyColumn(modifier= Modifier.padding(top = 16.dp)){
        items(movies){
                it -> MovieItem(movie = it, onClick = {
            onMovieClick(it)
        })
        }
    }
}