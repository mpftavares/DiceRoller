package com.example.diceroller.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.diceroller.ui.theme.components.DiceResult
import com.example.diceroller.DiceRollerScreen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun NavGraph (navController: NavHostController, modifier: Modifier) {
    var result by rememberSaveable() { mutableIntStateOf(1) }
    val goToScreen: (Int) -> Unit = {
        navController.navigate(Screens.DiceResult.route.replace("{result}", it.toString()))
    }

    NavHost(
        navController = navController,
        startDestination = Screens.Roll.route
    ) {
        composable(route = Screens.Roll.route){
            DiceRollerScreen(result = result, onResultChange = { result = it }, onShowResult = goToScreen, modifier = modifier)
        }
        composable ( route = Screens.DiceResult.route ) { navBackStack ->
            val param: Int = navBackStack.arguments?.getString("result")?.toIntOrNull() ?: 1
            DiceResult(
                modifier = modifier,
                screen = param,
                result = result,
                onResultChange = { result = it },
                onGoToScreen = goToScreen,
                onBack = { navController.navigate(Screens.Roll.route) },
            )
        }
    }
}