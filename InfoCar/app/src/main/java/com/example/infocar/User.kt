package com.example.infocar

import com.google.type.Date

class User {
    companion object Factory {
        fun create(): User = User()
    }

    var id: String? = null
    var email: String? = null
    var date: Date? = null
    var done: Boolean? = false

   /* private val id = ""
    private val email = ""
    private val phone = ""
    private var date = ""*/

}