package com.example.infocar.models

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class CarInfo(
    var carBrand: String = "",
    var carModel: String = "",
    var carType: String = "",
    var fuelType: String = "",
    var engineVolume: String = "",
    var dateOfRegister: String = "",
    var kilometersPassed: String = "",
    var licensePlateNumber: String = "",
    @Exclude val uid: String? = ""
)