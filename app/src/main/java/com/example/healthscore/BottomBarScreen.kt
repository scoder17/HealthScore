package com.example.healthscore

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: BottomBarScreen(
        route ="home",
        title = "home",
        icon = Icons.Filled.Home
    )

    object Medicine: BottomBarScreen(
        route ="medicine",
        title = "medicine",
        icon = Icons.Filled.Home
    )

    object Vitals: BottomBarScreen(
        route ="home",
        title = "home",
        icon = Icons.Filled.Home
    )
    object Aid: BottomBarScreen(
        route = "vitals",
        title = "vitals",
        icon = Icons.Filled.Medication
    )
    object Profile: BottomBarScreen(
        route = "profile",
        title = "profile",
        icon = Icons.Filled.Person
    )
}