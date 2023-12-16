package com.example.healthscore.data

data class Patient(
    val patientName:String,
    val patientId: Int
)

val patients = mutableListOf(
    Patient("ABC",1001)
)