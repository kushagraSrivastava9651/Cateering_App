package com.example.cateeringapp.Screen

sealed class Screen(val route:String){
    object LoginScreen:Screen("loginscreen")
    object SignupScreen:Screen("signupscreen")
    object HomeScreen:Screen("homeScreen")

}