package com.example.android.composedemo.examples

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.android.composedemo.ui.theme.ComposeDemoTheme
import kotlinx.coroutines.launch

/**
 * Created by murodjon on 2021/09/03
 */
@Composable
@ExperimentalCoilApi
fun LayoutScaffold() {
    // We save the scrolling position with this state that can also
    // be used to programmatically scroll the list
    val scrollState = rememberLazyListState()
    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Scaffold Example")
                },
                actions = {
                    Button(onClick = {
                        coroutineScope.launch {
                            // 0 is the first item index
                            scrollState.animateScrollToItem(99)
                        }
                    }) {
                        Text(text = "Bottom")
                    }
                    Button(onClick = {
                        coroutineScope.launch {
                            // listSize - 1 is the last index of the list
                            scrollState.animateScrollToItem(0)
                        }
                    }) {
                        Text(text = "Top")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        BodyContent(Modifier.padding(it), scrollState)
    }
}

@Composable
@ExperimentalCoilApi
fun BodyContent(modifier: Modifier = Modifier, scrollState: LazyListState) {
    SimpleItemList(modifier, scrollState)
}

@Composable
fun SimpleList(modifier: Modifier) {
    // We save the scrolling position with this state that can also be
    // used to programmatically scroll the list
    val scrollState = rememberScrollState()
    Column(modifier = modifier.verticalScroll(scrollState)) {
        repeat(100) {
            Text(text = "Item: $it")
        }
    }
}

@Composable
@ExperimentalCoilApi
fun SimpleItemList(modifier: Modifier, scrollState: LazyListState) {
//    // We save the scrolling position with this state that can also
//    // be used to programmatically scroll the list
//    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState) {
        items(100) {
            ImageListItem(index = it)
        }
    }
}

@Composable
@ExperimentalCoilApi
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(data = "https://developer.android.com/images/brand/Android_Robot.png"),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Preview(showBackground = true)
@ExperimentalCoilApi
@Composable
fun LayoutScaffoldPreview() {
    ComposeDemoTheme {
        LayoutScaffold()
    }
}