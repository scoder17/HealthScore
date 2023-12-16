package com.example.healthscore.data

data class PatientData(
    var patientName:String="",
    var email:String="",
    var password:String="",
    var medNotes:MutableList<String>,
){
    constructor() : this("", "", "", mutableListOf())
}
