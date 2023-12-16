package com.example.healthscore.ui.theme.theme

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.healthscore.BottomBarScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route)
    {
        composable(route=BottomBarScreen.Home.route){

        }
        composable(route=BottomBarScreen.Medicine.route){

        }
        composable(route=BottomBarScreen.Vitals.route){

        }
        composable(route=BottomBarScreen.Aid.route){

        }
        composable(route=BottomBarScreen.Profile.route){

        }
    }
}