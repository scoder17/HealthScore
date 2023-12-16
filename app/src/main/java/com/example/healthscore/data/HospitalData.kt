package com.example.healthscore.data

data class HospitalData(
    var hospitalName:String="",
    var hospitalId:String="",
    var hospitalEmail:String="",
    var password:String="",
    var doctorId:MutableList<String>
){
    constructor() : this("", "","","", mutableListOf() )

}
