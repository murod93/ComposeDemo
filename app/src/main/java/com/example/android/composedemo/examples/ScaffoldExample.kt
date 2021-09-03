package com.example.android.composedemo.examples

import android.util.Log
import android.widget.ImageButton
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android.composedemo.ui.theme.ComposeDemoTheme

/**
 * Created by murodjon on 2021/09/03
 */
@Composable
fun LayoutScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Scaffold Example")
                },
                actions = {
                    IconButton(onClick = { Log.e("TTT", "onClick") }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                    Button(onClick = { Log.e("TTT", "onClick share") }) {
                        Text(text = "Share")
                        Icon(Icons.Filled.Share, contentDescription = "Share")
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
//            BottomNavigation(modifier = Modifier) {
//                BottomNavigationItem(
//                    selected = false,
//                    onClick = { /*TODO*/ },
//                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") })
//                BottomNavigationItem(
//
//                    selected = false,
//                    onClick = { /*TODO*/ },
//                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") })
//            }
        }
    ) {
        BodyContent(Modifier.padding(it))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    SimpleItemList(modifier)
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
fun SimpleItemList(modifier: Modifier) {
    // We save the scrolling position with this state that can also
    // be used to programmatically scroll the list
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState) {
        items(100) {
            Text(text = "Item: $it")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LayoutScaffoldPreview() {
    ComposeDemoTheme {
        LayoutScaffold()
    }
}