package com.example.healthscore.data

import androidx.compose.ui.graphics.vector.ImageVector
import com.google.gson.annotations.SerializedName

data class AccessData(
    var access_token: String,
    var value: String,
    var unit: String,
    var icon: ImageVector,
    var vital: String,
)

data class ResponseData(
    @SerializedName("data")
    var data: List<VitalData>,
)

data class VitalData(
    @SerializedName("name")
    var name: String,
    var value: String,
    var unit: String,
    var icon: ImageVector,
)
