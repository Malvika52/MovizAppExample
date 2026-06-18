package com.moviz.app.example.screens

import android.R.attr.maxLines
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.moviz.app.example.retrofit.Movie

@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit){

    Card(elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(12.dp ).fillMaxWidth(),
        onClick = onClick) {

        Row(modifier = Modifier.padding(8.dp)) {
            AsyncImage(model = movie.image, contentDescription = "Movie Image",
                modifier = Modifier.size(150.dp, 200.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = movie.title, style = MaterialTheme.typography.labelLarge)
                Text(text = movie.description, style = MaterialTheme.typography.bodySmall)
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(movie.genre){
                        genre -> Genre(genre)
                    }
                }
            }
        }
    }

}

@Composable
fun Genre(genre : String){
    Text(text = genre,
        modifier = Modifier.padding(4.dp).fillMaxWidth(),
        maxLines = 2, style = MaterialTheme.typography.labelSmall,
        )
}
