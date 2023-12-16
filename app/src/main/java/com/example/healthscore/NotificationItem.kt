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
        title = "home",
        icon = Icons.Filled.Home
    )

    object Medicine: NotificationItem(
        route ="meds",
        title = "meds",
        icon = Icons.Filled.Medication
    )

    object Vitals: NotificationItem(
        route ="vitals",
        title = "vitals",
        icon = Icons.Filled.MonitorHeart
    )
    object Aid: NotificationItem(
        route = "aid",
        title = "aid",
        icon = Icons.Filled.Newspaper
    )
    object Profile: NotificationItem(
        route = "profile",
        title = "profile",
        icon = Icons.Filled.Person
    )
}