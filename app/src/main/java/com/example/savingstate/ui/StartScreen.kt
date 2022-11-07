package com.example.savingstate.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.savingstate.R

@Composable
fun StartScreen(
    onZipCodeSaved: () -> Unit,
    modifier: Modifier = Modifier) {

    //rememberSaveable makes it so the new value of zipCode can recompose and be remembered.
    var zipCode by rememberSaveable {
        mutableStateOf("98038")
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ){
        TextField(
            value = zipCode,
            onValueChange = {zipCode = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
        Button(
            onClick = onZipCodeSaved,
            Modifier.padding(top = 8.dp)
        ) {
            Text(stringResource(id = R.string.button_save_and_next)) //Button label
        }
    }

    /**Experiment with button that increments a value*/
    //Could pass in zipCode *= 2 to multiply it
    //ZipCodeSaver(zipCode, {zipCode++}, modifier)
}


/**Experiment with button that increments a value*/
/*
@Composable
private fun ZipCodeSaver(zipCode: Int, onIncrement: () -> Unit, modifier: Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Zipcode: $zipCode",            //updates the text
            modifier = modifier.padding(16.dp)
        )
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp)) {
            Text("Add one") //Button label
        }
    }
}
*/

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    StartScreen(onZipCodeSaved = {})
}