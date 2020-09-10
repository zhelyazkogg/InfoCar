package com.example.infocar.models

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Reminders(
    val carLiabilityInsurance: String = "", //граждаска отговорност
    val carHullInsurance: String = "", // автокаско на автомобила
    val carInspection: String = "", // преглед на автомобила
    val carTax: String = "", // данък на автомобила
    val dateOfReminder: String = "", // дата за алармата

    @Exclude val uid: String = ""

)