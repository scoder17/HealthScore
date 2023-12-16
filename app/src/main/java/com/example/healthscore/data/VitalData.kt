package com.example.healthscore.data

import androidx.compose.ui.graphics.vector.ImageVector

data class VitalData(
    var value: String,
    var unit: String,
    var icon: ImageVector,
    var vital: String,
)
