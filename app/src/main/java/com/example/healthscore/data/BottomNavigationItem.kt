package com.example.healthscore.data

import android.icu.text.CaseMap.Title
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem (
    val title: String,
    val selectedIcon:ImageVector,
    val unselectedIcon:ImageVector,
    val hasNews:Boolean,
    val badgeCount:Int?=null
)