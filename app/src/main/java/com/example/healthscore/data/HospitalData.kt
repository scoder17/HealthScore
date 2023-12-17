package com.example.healthscore.data

data class HospitalData(
    var hospitalName:String="",
    var hospitalId:String="",
    var hospitalEmail:String="",
    var password:String="",
    var departmentId:MutableList<String>
){
    constructor() : this("", "","","", mutableListOf() )

}
