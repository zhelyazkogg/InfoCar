package com.example.infocar.models

import com.google.firebase.database.Exclude

data class User (
    val email: String = "",
    @Exclude val uid: String? = ""

)
   /*{ companion object Factory {
        fun create(): User = User()
    }

    var id: String? = null
    var email: String? = null
    var date: Date? = null
    var done: Boolean? = false

    var carBrand: String? = null
    var carModel: String? = null
    var carType: String? = null
    var fuelType: String? = null
    var engineVolume: String? = null
    var dateOfRegister: String? = null
    var kmPassed: String? = null
    var licensePlateNumber: String? = null*/

   /* private val id = ""
    private val email = ""
    private val phone = ""
    private var date = ""
    }*/
