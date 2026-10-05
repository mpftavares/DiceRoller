package com.example.diceroller.ui.theme.components.results

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.diceroller.R

@Composable
fun Five(result: Int = 5) {
    Text(
        stringResource(R.string.result) + ": " + result.toString()
    )
}