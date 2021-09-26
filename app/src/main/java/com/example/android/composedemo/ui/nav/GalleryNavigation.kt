package com.example.android.composedemo.ui.nav

import androidx.navigation.NamedNavArgument

object GalleryNavigation {
    val _arguments = emptyList<NamedNavArgument>()

    fun gallery() = object : NavigationCommand {
        override val arguments: List<NamedNavArgument>
            get() = _arguments
        override val destination: String
            get() = "gallery"
    }
}