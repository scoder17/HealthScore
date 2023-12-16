package com.example.healthscore.data

data class Doctor(
    val doctorName:String,
    val doctorId:Int
)

val doctors = mutableListOf(
    Doctor("Dr. Gautam",101)
)