package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.diceroller.navigation.NavGraph
import com.example.diceroller.helpers.diceImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Composable
fun DiceRollerApp() {
    val navController = rememberNavController()
    Scaffold(contentWindowInsets = WindowInsets.safeDrawing) { innerPadding ->
        NavGraph(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding)
        )
    }
}

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

@Preview(showBackground = true)
@Composable
fun DiceRollerAppPreview() {
    DiceRollerApp()
}