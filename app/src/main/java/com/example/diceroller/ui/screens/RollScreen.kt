package com.example.diceroller.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.R
import com.example.diceroller.helpers.diceImage

@Composable
fun DiceRollerScreen(
    modifier: Modifier = Modifier,
    result: Int = 1,
    onResultChange: (Int) -> Unit,
    onShowResult: (Int) -> Unit,
) {
    DiceWithButtonAndImage(
        result = result,
        onResultChange = onResultChange,
        onShowResult = onShowResult,
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceWithButtonAndImage(
    modifier: Modifier = Modifier,
    result: Int = 1,
    onResultChange: (Int) -> Unit,
    onShowResult: (Int) -> Unit,
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(diceImage(result)),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = {
            onResultChange((1..6).random())
        }) {
            Text(stringResource(R.string.roll), fontSize = 24.sp)
        }
        Button(onClick = { onShowResult(result) }) {
            Text(stringResource(R.string.go_to_result), fontSize = 24.sp)
        }
    }
}
