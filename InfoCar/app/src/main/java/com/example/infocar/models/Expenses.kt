package com.example.infocar.models

import com.google.firebase.database.Exclude

data class Expenses (
    val id: String = "",
    val fuelExpense: String="",
    val partsExpense: String="",
    val insuranceExpense: String="",
    val tiresExpense: String="",
    val carReviewExpense: String="",
    val carMaintenanceExpense: String="",
    @Exclude val uid: String = ""

)