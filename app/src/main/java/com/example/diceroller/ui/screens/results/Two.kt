package com.example.diceroller.ui.screens.results

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.diceroller.R

@Composable
fun Two(result: Int = 2, onResultChange: (Int) -> Unit) {
    val incrementBy = 2
    Column {
        Button(onClick = { onResultChange(result + incrementBy) }, enabled = result < 5) {
            Text(
                stringResource(R.string.increment_by) + ": " + incrementBy
            )
        }
    }
}