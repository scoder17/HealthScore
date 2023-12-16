package com.example.healthscore.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bloodtype
import androidx.compose.material.icons.outlined.Height
import androidx.compose.material.icons.outlined.MonitorHeart
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material.icons.outlined.VolunteerActivism

object VitalsData{
    var vitalData= mutableListOf<VitalData>(
        VitalData(
            value="100",
            unit="mg",
            icon=Icons.Outlined.Bloodtype,
            vital="Blood Type"
        ),
        VitalData(
            value="100",
            unit="mg",
            icon=Icons.Outlined.MonitorWeight,
            vital="Blood Type"
        ),
        VitalData(
            value="100",
            unit="mg",
            icon=Icons.Outlined.Height,
            vital="Blood Type"
        ),
        VitalData(
            value="100",
            unit="mg",
            icon=Icons.Outlined.MonitorHeart,
            vital="Blood Type"
        ),
        VitalData(
            value="100",
            unit="mg",
            icon=Icons.Outlined.VolunteerActivism,
            vital="Blood Type"
        ),
        VitalData(
            value="100",
            unit="mg",
            icon=Icons.Outlined.VolunteerActivism,
            vital="Blood Type"
        ),
    )
}