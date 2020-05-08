package com.example.infocar.activities

import android.content.Context
import android.widget.Toast
import com.example.infocar.models.User
import com.google.firebase.database.DataSnapshot

fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this,text,duration).show()
}

fun DataSnapshot.asUser(): User? =
    getValue(User::class.java)?.copy(uid = key)