package com.example.savingstate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.savingstate.ui.theme.ShadyGray
import com.example.savingstate.ui.theme.SunnyYellow

/** NAVIGATES TO EITHER THE SUN OR SHADE SCREEN */
@Composable
fun ChoiceScreen(
    onNavigateToSunButtonClicked: (Int) -> Unit,   /* CLICK FIND SUN */
    onNavigateToShadeButtonClicked: (Int) -> Unit, /* CLICK FIND SHADE */
    modifier: Modifier = Modifier) {

    var selectedValue by rememberSaveable { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(color = SunnyYellow)
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Row {
                Button(
                    onClick = { onNavigateToSunButtonClicked }, /* CLICKED FIND SUN */
                    colors = ButtonDefaults.buttonColors(backgroundColor = ShadyGray)
                ) {
                    Text(
                        text = stringResource(id = R.string.screen_sun),
                        color = Color.White,
                        fontSize = 24.sp
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .background(color = ShadyGray)
                .fillMaxWidth()
                .weight(1f)
            ,
            contentAlignment = Alignment.Center
        ) {
            Row {
                Button(
                    onClick = { onNavigateToShadeButtonClicked }, /* CLICKED FIND SHADE */
                    colors = ButtonDefaults.buttonColors(backgroundColor = SunnyYellow)
                ) {
                    Text(
                        text = stringResource(id = R.string.screen_shade),
                        color = Color.Black,
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChoiceScreenPreview() {
   ChoiceScreen(onNavigateToSunButtonClicked = {}, onNavigateToShadeButtonClicked = {})
}