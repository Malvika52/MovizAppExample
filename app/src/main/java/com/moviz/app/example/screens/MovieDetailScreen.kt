package com.moviz.app.example.screens

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.moviz.app.example.R
import com.moviz.app.example.retrofit.Movie
import com.moviz.app.example.viewmodel.MovieViewModel

@Composable
fun MovieDetailScreen(viewModel: MovieViewModel, navController: NavController){
    Column {
        val selectedMovie = viewModel.selectedMovie.collectAsState()

        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = {
                navController.navigate("list")
            }, modifier = Modifier.padding(10.dp)) {
                Icon(painter = painterResource(R.drawable.baseline_arrow_back_24),
                    contentDescription = "Back")
            }
            Text(text = selectedMovie.value!!.title, style = MaterialTheme.typography.titleLarge, fontSize = 35.sp,
                fontFamily = FontFamily.Cursive, modifier = Modifier.width(400.dp).padding(10.dp), textAlign = TextAlign.Center)
        }
        Column(Modifier.verticalScroll(rememberScrollState())) {
            AsyncImage(model = selectedMovie.value!!.bigImage, contentDescription = "Movie Image",
                modifier = Modifier.fillMaxWidth().padding(20.dp).height(400.dp))

            Text(text = "Rank : ${selectedMovie.value!!.rank}", style = MaterialTheme.typography.bodyMedium, fontSize = 20.sp,
                fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold,
                modifier = Modifier.width(400.dp).padding(5.dp), textAlign = TextAlign.Center)
            Text(text = "Rating : ${selectedMovie.value!!.rating}", style = MaterialTheme.typography.bodyMedium, fontSize = 20.sp,
                fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold,
                modifier = Modifier.width(400.dp).padding(5.dp), textAlign = TextAlign.Center)
            Text(text = "Year : ${selectedMovie.value!!.year}", style = MaterialTheme.typography.bodyMedium, fontSize = 20.sp,
                fontFamily = FontFamily.Cursive, fontWeight = FontWeight.Bold,
                modifier = Modifier.width(400.dp).padding(5.dp), textAlign = TextAlign.Center)

        }
    }

}