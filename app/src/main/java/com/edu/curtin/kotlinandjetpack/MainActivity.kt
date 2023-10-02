package com.edu.curtin.kotlinandjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.edu.curtin.kotlinandjetpack.ui.screens.HomeScreen
import com.edu.curtin.kotlinandjetpack.ui.screens.WorksScreen
import com.edu.curtin.kotlinandjetpack.ui.theme.KotlinAndJetpackTheme
import com.edu.curtin.kotlinandjetpack.viewmodel.ExampleViewmodel

sealed class Destination(val route: String){
    object HomeScreen: Destination("Home")
    object WorksScreen: Destination("Works")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinAndJetpackTheme {
                val viewModel = viewModel<ExampleViewmodel>()

                val navController = rememberNavController()
                NavigationAppHost(navController, viewModel)
            }
        }
    }
}

@Composable
fun NavigationAppHost (navController: NavHostController, viewModel: ExampleViewmodel) {
    NavHost(
        navController = navController,
        startDestination = Destination.HomeScreen.route
    ){
        composable(route = Destination.HomeScreen.route){ HomeScreen(navController,viewModel) }
        composable(route = Destination.WorksScreen.route){ WorksScreen(viewModel) }
    }
}
