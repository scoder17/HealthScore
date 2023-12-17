package com.example.healthscore.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Air
import androidx.compose.material.icons.outlined.Backpack
import androidx.compose.material.icons.outlined.Bloodtype
import androidx.compose.material.icons.outlined.Compress
import androidx.compose.material.icons.outlined.Height
import androidx.compose.material.icons.outlined.MonitorHeart
import androidx.compose.material.icons.outlined.MonitorWeight
import androidx.compose.material.icons.outlined.Thermostat
import androidx.compose.material.icons.outlined.VolunteerActivism

object VitalsData{
    var vitalData= mutableListOf<VitalData>(
        VitalData(
            value="98.7",
            unit="F",
            icon=Icons.Outlined.Thermostat,
            name="Temperature"
        ),
        VitalData(
            value="80",
            unit="mmHg",
            icon=Icons.Outlined.Compress,
            name="Blood Pressure"
        ),
        VitalData(
            value="90",
            unit="mg/dL",
            icon=Icons.Outlined.Height,
            name="Glucose Level"
        ),
        VitalData(
            value="100",
            unit="mg",
            icon=Icons.Outlined.Bloodtype,
            name="Blood Type"
        ),
        VitalData(
            value="80",
            unit="bpm",
            icon=Icons.Outlined.MonitorHeart,
            name="Heart Rate"
        ),
        VitalData(
            value="20",
            unit="b/min",
            icon=Icons.Outlined.VolunteerActivism,
            name="Respiratory Rate"
        ),
        VitalData(
            value="98",
            unit="%",
            icon=Icons.Outlined.Air,
            name="SpO2"
        ),
        VitalData(
            value="70",
            unit="kg",
            icon=Icons.Outlined.MonitorWeight,
            name="Weight"
        ),
        VitalData(
            value="170",
            unit="cm",
            icon=Icons.Outlined.Height,
            name="Height"
        ),
        VitalData(
            value="20",
            unit="kg/m2",
            icon=Icons.Outlined.Backpack,
            name="BMI"
        ),
    )
}
