package com.example.diceroller.ui.theme.components

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.R
import com.example.diceroller.helpers.diceImage
import com.example.diceroller.ui.theme.components.results.Five
import com.example.diceroller.ui.theme.components.results.Four
import com.example.diceroller.ui.theme.components.results.One
import com.example.diceroller.ui.theme.components.results.Six
import com.example.diceroller.ui.theme.components.results.Three
import com.example.diceroller.ui.theme.components.results.Two

@Composable
fun DiceResult(
    modifier: Modifier = Modifier,
    screen: Int = 1,
    result: Int = 1,
    onResultChange: (Int) -> Unit,
    onGoToScreen: (Int) -> Unit,
    onBack: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            stringResource(R.string.dice_result) + ": " + result.toString(), fontSize = 24.sp
        )
        if (screen != 6) {
            Image(
                painter = painterResource(diceImage(result)),
                contentDescription = result.toString()
            )
        }
        ResultComponent(
            screen = screen,
            result = result,
            onResultChange = onResultChange,
            onGoToScreen = onGoToScreen
        )
        Spacer(modifier.padding(12.dp))
        Button(onClick = onBack) {
            Text(stringResource(R.string.back), fontSize = 24.sp)
        }
    }

}

@Composable
fun ResultComponent(
    screen: Int = 1,
    result: Int = 1,
    onResultChange: (Int) -> Unit,
    onGoToScreen: (Int) -> Unit,
) {
    when (screen) {
        1 -> One(result)
        2 -> Two(result, onResultChange)
        3 -> Three(result, onResultChange)
        4 -> Four(result, onGoToScreen)
        5 -> Five(result)
        6 -> Six(result, onGoToScreen)
    }
}

@Preview
@Composable
fun DiceResultPreview() {
    DiceResult(screen = 1, result = 1, onResultChange = {}, onGoToScreen = {}, onBack = {})
}