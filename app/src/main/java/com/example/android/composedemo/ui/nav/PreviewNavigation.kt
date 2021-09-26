package com.example.android.composedemo.ui.nav

import androidx.navigation.NamedNavArgument

object PreviewNavigation {
    fun preview() = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>
            get() = listOf()
        override val destination: String
            get() = "preview"
    }
}