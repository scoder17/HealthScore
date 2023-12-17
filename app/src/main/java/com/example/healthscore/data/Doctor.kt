package com.example.healthscore.data

data class Doctor(
    val doctorName:String="",
    val doctorId:String="",
    val departmentId:String=""

)

val doctors = mutableListOf(
    Doctor("Dr. Gautam","101","")
)