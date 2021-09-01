package com.example.android.composedemo.examples

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Created by murodjon on 2021/09/02
 */

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "There")) {
    val count = remember { mutableStateOf(0) }

    Column(
        modifier =
        Modifier
            .padding(10.dp)
            .fillMaxHeight()
    ) {
        NameList(names = names, modifier = Modifier.weight(1f))
        Counter(count.value) {
            count.value = it
        }
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(names) {
            Greeting(name = it)
            Divider(color = Color.Black)
        }
    }
}

@Composable
fun Greeting(name: String) {
    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)
    Text(
        text = name,
        modifier = Modifier
            .padding(24.dp)
            .background(backgroundColor)
            .clickable { isSelected = !isSelected }
    )
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    val backgroundColor by animateColorAsState(if (count > 5) Color.Red else Color.Green)
    Button(
        onClick = { updateCount(count + 1) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        )
    ) {
        Text(
            text = "I've been clicked $count times.",
            color = Color.Blue
        )
    }
}
