package com.example.android.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android.composedemo.ui.screen.GalleryScreen
import com.example.android.composedemo.ui.screen.PreviewScreen
import com.example.android.composedemo.ui.screen.SplashScreen
import com.example.android.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GalleryApp()
        }
    }
}

@Composable
fun GalleryApp() {
    ComposeDemoTheme {
        // create navController
        val navController = rememberNavController()

        GalleryAppNavHost(navController = navController)
    }
}

@Composable
fun GalleryAppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = MainScreen.Splash.name,
        modifier = modifier
    ) {
        composable(MainScreen.Gallery.name) {
            GalleryScreen()
        }
        composable(MainScreen.Preview.name) {
            PreviewScreen()
        }
        composable(MainScreen.Splash.name) {
            SplashScreen(navController)
        }
    }
}
