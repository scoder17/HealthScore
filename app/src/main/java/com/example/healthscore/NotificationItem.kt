package com.example.healthscore

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NotificationItem (
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: NotificationItem(
        route ="home",
        title = "home",
        icon = Icons.Filled.Home
    )

    object Medicine: NotificationItem(
        route ="medicine",
        title = "medicine",
        icon = Icons.Filled.Home
    )

    object Vitals: NotificationItem(
        route ="home",
        title = "home",
        icon = Icons.Filled.Home
    )
    object Aid: NotificationItem(
        route = "vitals",
        title = "vitals",
        icon = Icons.Filled.Medication
    )
    object Profile: NotificationItem(
        route = "profile",
        title = "profile",
        icon = Icons.Filled.Person
    )
}