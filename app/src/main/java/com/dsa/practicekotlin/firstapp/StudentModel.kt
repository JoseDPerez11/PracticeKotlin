package com.dsa.practicekotlin.firstapp

import java.io.Serializable

data class StudentModel(
    var name: String,
    var lastname: String,
    var profession: String,
    var research: String
) : Serializable {

}
