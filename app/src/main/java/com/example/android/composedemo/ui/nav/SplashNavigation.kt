package com.example.android.composedemo.ui.nav

import androidx.navigation.NamedNavArgument

object SplashNavigation {
    fun splash() = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>
            get() = listOf()
        override val destination: String
            get() = "splash"
    }
}