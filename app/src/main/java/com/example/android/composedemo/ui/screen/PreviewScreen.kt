package com.example.android.composedemo.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PreviewScreen() {
    Box {
        Text(text = "Preview", Modifier.align(Alignment.Center))
    }
}