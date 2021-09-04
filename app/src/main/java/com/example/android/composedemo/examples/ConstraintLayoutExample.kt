package com.example.android.composedemo.examples

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/**
 * Created by murodjon on 2021/09/04
 */
@ExperimentalComposeUiApi
@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        // create references for the composables to constrain
        val (button1, button2, text) = createRefs()

        Button(onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(button1) {
                top.linkTo(parent.top, margin = 16.dp)
            }) {
            Text(text = "Button 1")
        }

        Text(text = "Text", modifier = Modifier.constrainAs(text) {
            top.linkTo(button1.bottom, margin = 16.dp)
            centerAround(button1.end)
        })
        
        val barrier = createEndBarrier(button1, text)
        Button(onClick = { /*TODO*/ },
        modifier = Modifier.constrainAs(button2){
            top.linkTo(parent.top, margin = 16.dp)
            start.linkTo(barrier)
        }) {
            Text(text = "Button 2")
        }
    }
}

@ExperimentalComposeUiApi
@Preview(showBackground = true)
@Composable
fun ConstraintLayoutContentPreview() {
    ConstraintLayoutContent()
}

@ExperimentalComposeUiApi
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ConstraintLayoutContentNightPreview()
{
    ConstraintLayoutContent()
}