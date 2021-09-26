package com.example.android.composedemo.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android.composedemo.R
import com.example.android.composedemo.data.model.GalleryItem

@ExperimentalFoundationApi
@Composable
fun GalleryScreen() {
    Scaffold(
        topBar = {
            GalleryScreenTopBar()
        },
        bottomBar = {
            GalleryScreenBottomBar(
                modifier = Modifier,
                shape = CircleShape,
                onHomeClick = {},
                onSettingsClick = {})
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            FloatingActionButtonContent(CircleShape) {

            }
        }
    ) {
        GalleryScreenBody(listOf())
    }
}

@Composable
fun GalleryScreenTopBar() {
    Text(
        text = stringResource(id = R.string.gallery_title),
        modifier = Modifier.padding(12.dp),
        style = MaterialTheme.typography.h5
    )
}

@Composable
fun GalleryScreenBottomBar(
    shape: Shape,
    modifier: Modifier,
    onSettingsClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    val settingsKey = "settings"
    val homeKey = "home"
    val activeItem = remember {
        mutableStateOf(homeKey)
    }

    BottomAppBar(cutoutShape = shape, modifier = modifier, backgroundColor = Color.White) {
        BottomNavigation(backgroundColor = Color.White) {
            BottomNavigationItem(selected = activeItem.value == homeKey, onClick = {
                onHomeClick.invoke()
                activeItem.value = homeKey
            }, icon = {
                BottomNavItemIcon(
                    active = activeItem.value == homeKey,
                    imageVector = Icons.Default.Home
                )
            }, label = {
                BottomNavItemLabel(
                    text = stringResource(id = R.string.gallery_nav_item_home),
                    active = activeItem.value == homeKey
                )
            }, alwaysShowLabel = true)

            BottomNavigationItem(selected = activeItem.value == settingsKey, onClick = {
                onSettingsClick.invoke()
                activeItem.value = settingsKey
            }, icon = {
                BottomNavItemIcon(
                    active = activeItem.value == settingsKey,
                    imageVector = Icons.Default.Settings
                )
            }, label = {
                BottomNavItemLabel(
                    text = stringResource(id = R.string.gallery_nav_item_settings),
                    active = activeItem.value == settingsKey
                )
            }, alwaysShowLabel = true)
        }
    }
}

@Composable
private fun BottomNavItemIcon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    active: Boolean
) {
    Icon(
        imageVector,
        contentDescription = null,
        modifier = modifier,
        tint = if (active)
            Color.Green
        else Color.Unspecified
    )
}

@Composable
private fun BottomNavItemLabel(modifier: Modifier = Modifier, text: String, active: Boolean) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 12.sp,
        color =
        if (active)
            Color.Green
        else Color.DarkGray,
    )
}

@ExperimentalFoundationApi
@Composable
fun GalleryScreenBody(items: List<GalleryItem>) {
    GalleryList(modifier = Modifier, galleryItems = items, onItemClick = { /*TODO*/ }) {

    }
}

@ExperimentalFoundationApi
@Composable
fun GalleryList(
    modifier: Modifier,
    galleryItems: List<GalleryItem>,
    onItemClick: () -> Unit,
    onItemLongClick: () -> Unit
) {
    if (galleryItems.isEmpty()) {
        GalleryEmpty()
    } else {
        LazyVerticalGrid(cells = GridCells.Fixed(3), content = {
            items(galleryItems) { galleryItem ->
                GalleryItemView(
                    modifier = Modifier,
                    item = galleryItem,
                    onItemClick = onItemClick, onItemLongClick = onItemLongClick
                )
            }
        }, modifier = modifier)
    }
}

@Composable
fun GalleryEmpty() {

}

@Composable
fun GalleryItemView(
    modifier: Modifier,
    item: GalleryItem,
    onItemClick: () -> Unit,
    onItemLongClick: () -> Unit
) {

}

@Composable
fun FloatingActionButtonContent(shape: Shape, onPlusClick: () -> Unit) {
    FloatingActionButton(
        onClick = onPlusClick,
        shape = shape,
        contentColor = Color.White,
        backgroundColor = Color.Green
    ) {
        Icon(Icons.Default.Add, contentDescription = null)
    }
}

@ExperimentalFoundationApi
@Preview
@Composable
fun GalleryScreenPreview() {
    GalleryScreen()
}