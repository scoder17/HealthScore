package com.example.healthscore.data

data class PatientData(
    var patientName:String="",
    var email:String="",
    var password:String="",
    var age:String="",
    var gender:String="",
    var medList:MutableList<String>,
    var docNotes:MutableList<String>
){
    constructor() : this("", "", "","","", mutableListOf(), mutableListOf())
}
