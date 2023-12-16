package com.example.healthscore

sealed class Routes (val route: String){
    object Login:Routes("Login")
}