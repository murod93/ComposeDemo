package com.example.android.composedemo.ui.nav

import androidx.navigation.NamedNavArgument

/**
 * [NavigationCommand] is going to define requirements for a navigation event
 */
interface NavigationCommand {
    val arguments: List<NamedNavArgument>
    val destination: String
}