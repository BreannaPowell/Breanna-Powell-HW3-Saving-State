package com.example.savingstate.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SunScreen(modifier: Modifier = Modifier) {

    Column {
        Text(
            text = "Show a list of nearby cities in the sun"
        )
    }

}

@Preview(showBackground = true)
@Composable
fun SunScreenPreview() {
    SunScreen()
}