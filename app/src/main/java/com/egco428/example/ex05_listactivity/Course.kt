package com.egco428.example.ex05_listactivity

class Course (val courseNumber: Int, val title: String, val description: String, val credits: Double){
    override fun toString(): String {
        return title
    }
}
