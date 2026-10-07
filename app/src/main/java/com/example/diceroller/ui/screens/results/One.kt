package com.example.diceroller.ui.screens.results

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.diceroller.R
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun One(result: Int = 1) {
    var temperature by remember { mutableIntStateOf(21) }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(16.dp))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {
        Text(
            stringResource(R.string.fav_travel_destination)
        )
        Text(
            stringResource(R.string.travel_destination)
        )
        Text(
            stringResource(R.string.temperature) + ": " + temperature + 'º'
        )
        Button(onClick = { temperature = (-10..30).random() }) {
            Text(stringResource(R.string.refresh_temperature))
        }
    }
}

@Preview
@Composable
fun OnePreview() {
    One()
}