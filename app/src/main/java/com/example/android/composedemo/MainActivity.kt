package com.example.android.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.android.composedemo.ui.nav.GalleryNavigation
import com.example.android.composedemo.ui.nav.PreviewNavigation
import com.example.android.composedemo.ui.nav.SplashNavigation
import com.example.android.composedemo.ui.screen.GalleryScreen
import com.example.android.composedemo.ui.screen.PreviewScreen
import com.example.android.composedemo.ui.screen.SplashScreen
import com.example.android.composedemo.ui.theme.ComposeDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GalleryApp()
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun GalleryApp() {
    ComposeDemoTheme {
        // create navController
        val navController = rememberNavController()

        GalleryAppNavHost(navController = navController)
    }
}

@ExperimentalFoundationApi
@Composable
fun GalleryAppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = SplashNavigation.splash().destination,
        modifier = modifier
    ) {
        composable(GalleryNavigation.gallery().destination) { backStackEntry ->
            // creates gallery VM from the current back stack entry
            GalleryScreen(hiltViewModel())
        }
        composable(PreviewNavigation.preview().destination) { backStackEntry ->
            // creates preview VM from the current backstackEntry
            PreviewScreen(hiltViewModel())
        }
        composable(SplashNavigation.splash().destination) {
            SplashScreen(navController)
        }
    }
}
