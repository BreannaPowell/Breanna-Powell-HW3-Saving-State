package com.example.savingstate

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ShadeScreen(){
    Column {
        Text(
            text = "Show a list of nearby cities in the shade"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShadeScreenPreview() {
    ShadeScreen()
}