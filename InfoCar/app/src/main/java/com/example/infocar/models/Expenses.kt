package com.example.infocar.models

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class Expenses(
    val title: String = "",
    val date: Date,
    val amount: Int,
    val description: String = "",
    @Exclude val uid: String? = ""
)
    /*val fuelExpense: String = "",
    val partsExpense: String = "",
    val insuranceExpense: String = "",
    val tiresExpense: String = "",
    val carReviewExpense: String = "",
    val carMaintenanceExpense: String = "",*/
