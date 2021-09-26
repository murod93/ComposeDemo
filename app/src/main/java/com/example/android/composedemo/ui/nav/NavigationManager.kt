package com.example.android.composedemo.ui.nav

import kotlinx.coroutines.flow.MutableStateFlow

class NavigationManager {
    var commands = MutableStateFlow(SplashNavigation.splash())

    fun navigate(directions: NavigationCommand) {
        commands.value = directions
    }
}