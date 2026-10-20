package com.example.conceptosbasicoscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onOpenArticle = {
                    navController.navigate("article")
                },
                onOpenTasks = {
                    navController.navigate("tasks")
                },
                onOpenQuadrants = {
                    navController.navigate("quadrants")
                }
            )
        }
        composable("article") {
            ComposeArticle()
        }
        composable("tasks") {
            TaskCompletedScreen()
        }
        composable("quadrants") {
            ComposeQuadrantsScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {
    MaterialTheme {
        AppNavigation()
    }
}
