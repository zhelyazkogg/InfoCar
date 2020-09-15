package com.example.infocar.models

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class Reminders(

    val title: String = "",
    val setDate: Date,
    val description: String = "",
    @Exclude val uid: String = ""

)
    /*val carLiabilityInsurance: String = "", //граждаска отговорност
    val carHullInsurance: String = "", // автокаско на автомобила
    val carInspection: String = "", // преглед на автомобила
    val carTax: String = "", // данък на автомобила
    val dateOfReminder: String = "", // дата за алармата*/

