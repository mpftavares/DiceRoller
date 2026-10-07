package com.example.diceroller.ui.screens.results

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.R
import com.example.diceroller.helpers.diceImage

@Composable
fun Six(
    result: Int = 6,
    onGoToScreen: (Int) -> Unit
) {
    var secondDice by rememberSaveable { mutableIntStateOf(1) }
    var hasRolled by rememberSaveable { mutableStateOf(false) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
            LabeledDice(stringResource(R.string.current_dice), result)
            LabeledDice(stringResource(R.string.second_dice), secondDice)
        }
        Button(onClick = {
            secondDice = (1..6).random()
            hasRolled = true
        }) {
            Text(stringResource(R.string.roll_second_dice))
        }

        if (hasRolled) {
            val won = secondDice >= result
            Text(
                stringResource(
                    if (won) R.string.you_won else R.string.you_lost,
                    secondDice,
                    result
                ),
                color = if (won) Color(0xFF2E7D32) else MaterialTheme.colorScheme.error,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            if (won) {
                Button(onClick = { onGoToScreen(secondDice) }) {
                    Text(stringResource(R.string.go_to_result))
                }
            }
        }
    }
}

@Composable
fun LabeledDice(label: String, value: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(label)
        Image(
            painter = painterResource(diceImage(value)),
            contentDescription = value.toString(),
            modifier = Modifier.width(120.dp)
        )
    }
}

@Preview
@Composable
fun SixPreview() {
    Six(6, onGoToScreen = {})
}
