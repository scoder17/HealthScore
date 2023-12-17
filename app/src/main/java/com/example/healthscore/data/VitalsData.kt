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
            name="Blood Type"
        ),
        VitalData(
            value="100",
            unit="mg",
            icon=Icons.Outlined.MonitorWeight,
            name="Blood Type"
        ),
        VitalData(
            value="100",
            unit="mg",
            icon=Icons.Outlined.Height,
            name="Blood Type"
        ),
        VitalData(
            value="100",
            unit="mg",
            icon=Icons.Outlined.MonitorHeart,
            name="Blood Type"
        ),
        VitalData(
            value="100",
            unit="mg",
            icon=Icons.Outlined.VolunteerActivism,
            name="Blood Type"
        ),
        VitalData(
            value="100",
            unit="mg",
            icon=Icons.Outlined.VolunteerActivism,
            name="Blood Type"
        ),
    )
}
