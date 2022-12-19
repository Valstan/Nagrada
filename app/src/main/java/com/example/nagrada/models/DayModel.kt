package com.example.nagrada.models

data class DayModel(
    val date: String,
    val prefix: String,
    val text: String,
    val ball: Int,
    val cash: Int,
    val currency: String
)