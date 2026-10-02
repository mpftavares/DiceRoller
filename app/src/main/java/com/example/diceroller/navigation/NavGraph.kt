package com.example.diceroller.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.diceroller.DiceResult
import com.example.diceroller.DiceRollerApp
import com.example.diceroller.DiceRollerScreen
import com.example.diceroller.DiceWithButtonAndImage

@Composable
fun NavGraph (navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screens.Roll.route
    ) {
        composable(route = Screens.Roll.route){
            DiceRollerScreen(navController = navController, modifier = modifier)
        }
        composable ( route = Screens.DiceResult.route ) { navBackStack ->
            val resultShow: Int = navBackStack.arguments?.getString("result")?.toIntOrNull() ?: 1
            DiceResult(navController = navController, modifier = modifier, resultShow = resultShow)
        }
    }
}