package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.diceroller.navigation.NavGraph
import com.example.diceroller.navigation.Screens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerApp()
        }
    }
}

@Composable
fun DiceRollerApp() {
    DiceRollerTheme {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ) { innerPadding ->
            NavGraph(navController = navController, modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun DiceRollerScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    result: Int = 1,
    onResultChange: (Int) -> Unit,
) {
    DiceWithButtonAndImage(
        navController,
        result = result,
        onResultChange = onResultChange,
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun DiceWithButtonAndImage(
    navController: NavController,
    modifier: Modifier = Modifier,
    result: Int = 1,
    onResultChange: (Int) -> Unit,
) {
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(onClick = {
            onResultChange((1..6).random())
        }) {
            Text(stringResource(R.string.roll), fontSize = 24.sp)
        }
        Button(onClick = {
            navController.navigate(
                Screens.DiceResult.route.replace(
                    oldValue = "{result}",
                    newValue = result.toString()
                )
            )
        }) {
            Text(stringResource(R.string.go_to_result), fontSize = 24.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerAppPreview() {
    DiceRollerApp()
}