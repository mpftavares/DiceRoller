package com.example.diceroller.ui.theme.components.results

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.R

@Composable
fun Four(result: Int = 4, onGoToScreen: (Int) -> Unit) {
    Column {
        for (x in 1..6) {
            Button(onClick = { onGoToScreen(x) }) {
                Text(stringResource(R.string.go_to_screen, x))
            }
        }
    }
}

@Preview
@Composable
fun FourPreview() {
    Four(4, onGoToScreen = {})
}