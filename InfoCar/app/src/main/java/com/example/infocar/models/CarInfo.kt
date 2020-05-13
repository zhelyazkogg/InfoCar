package com.example.infocar.models

import com.google.firebase.database.Exclude

data class CarInfo (
    val email: String = "",
    val carBrand: String="",
    val carModel: String="",
    val carType: String="",
    val fuelType: String="",
    val engineVolume: String="",
    val dateOfRegester: String="",
    val kilometersPassed: String="",
    val licensePlateNumber: String="",
    @Exclude val uid: String? = ""
)