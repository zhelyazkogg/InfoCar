package com.example.infocar

import com.google.type.Date

class User {
    companion object Factory {
        fun create(): User = User()
    }

    var id: String? = null
    var email: String? = null
    var date: Date? = null

   /* private val id = ""
    private val email = ""
    private val phone = ""
    private var date = ""*/

}