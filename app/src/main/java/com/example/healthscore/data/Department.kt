package com.example.healthscore.data

data class Department (
     val deptName:String,
     val deptId:Int,
)

val departments = mutableListOf(
    Department("Radiology",10),
)