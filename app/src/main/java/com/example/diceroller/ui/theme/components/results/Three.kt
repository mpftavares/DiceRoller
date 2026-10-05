package com.example.diceroller.ui.theme.components.results

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.R

@Composable
fun Three(result: Int = 3, onResultChange: (Int) -> Unit) {
    var text by remember { mutableStateOf(result.toString()) }

    Column() {
        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
                newText.toIntOrNull()?.takeIf { it in 1..6 }?.let(onResultChange)
            },
            label = { Text(stringResource(R.string.update_dice_value)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )
    }
}

@Preview
@Composable
fun ThreePreview() {
    Three(3, onResultChange = {})
}