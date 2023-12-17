package com.example.healthscore.data

data class Patient(
    val patientName:String="",
    val patientId: String="",
)

val patients = mutableListOf(
    Patient("ABC","1001")
)