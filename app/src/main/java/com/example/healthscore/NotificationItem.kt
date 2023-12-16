package com.example.healthscore

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Medication
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NotificationItem (
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: NotificationItem(
        route ="home",
        title = "Home",
        icon = Icons.Filled.Home
    )

    object Medicine: NotificationItem(
        route ="meds",
        title = "Meds",
        icon = Icons.Filled.Medication
    )

    object Vitals: NotificationItem(
        route ="vitals",
        title = "Vitals",
        icon = Icons.Filled.MonitorHeart
    )
    object Aid: NotificationItem(
        route = "aid",
        title = "Aid",
        icon = Icons.Filled.Newspaper
    )
    object Profile: NotificationItem(
        route = "profile",
        title = "Profile",
        icon = Icons.Filled.Person
    )
}