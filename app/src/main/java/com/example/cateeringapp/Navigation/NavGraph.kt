package com.example.cateeringapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cateeringapp.HomeScreen.HomeScreen
import com.example.cateeringapp.Screen.Screen
import com.example.cateeringapp.SignIn.LoginScreen
import com.example.cateeringapp.SignIn.SignUpScreen
import com.example.cateeringapp.ViewModel.AuthViewModel

@Composable
fun NavigationGraph(
    authViewModel: AuthViewModel,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SignupScreen.route
    ) {
        composable(Screen.SignupScreen.route) {
            SignUpScreen(
                authViewModel = authViewModel,
                onNavigateToLogin = { navController.navigate(Screen.LoginScreen.route) }
            )
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(
                authViewModel = authViewModel,
                onNavigateToSignUp = { navController.navigate(Screen.SignupScreen.route) }
            ){
                navController.navigate(Screen.HomeScreen.route)
            }
        }

        composable(Screen.HomeScreen.route){
            HomeScreen(navController)
        }
    }
}