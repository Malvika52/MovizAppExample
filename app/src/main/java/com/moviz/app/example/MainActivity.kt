package com.moviz.app.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moviz.app.example.repository.MovieRepository
import com.moviz.app.example.screens.MovieDetailScreen
import com.moviz.app.example.screens.Moviescreen
import com.moviz.app.example.ui.theme.MovizAppExampleTheme
import com.moviz.app.example.viewmodel.MovieViewModel
import com.moviz.app.example.viewmodel.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovizAppExampleTheme {
                val repository = MovieRepository()
                val viewmodelFactory  = MovieViewModelFactory(repository)
                val viewModel = ViewModelProvider(this , viewmodelFactory)[MovieViewModel::class.java]
                val navController = rememberNavController()
                NavHost(navController, startDestination = "list"){
                    composable("list"){
                        Moviescreen(viewModel, navController)
                    }
                    composable("detail"){
                        MovieDetailScreen(viewModel, navController)
                    }

                }

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MovizAppExampleTheme {
        Greeting("Android")
    }
}
