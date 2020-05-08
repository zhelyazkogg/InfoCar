package com.example.infocar.activities

import android.content.Context
import android.widget.Toast
import com.example.infocar.models.CarInfo
import com.example.infocar.models.Expenses
import com.example.infocar.models.User
import com.google.firebase.database.DataSnapshot

fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this,text,duration).show()
}

fun DataSnapshot.asUser(): User? =
    getValue(User::class.java)?.copy(uid = key)

fun DataSnapshot.uCarInfo(): CarInfo? =
    getValue(CarInfo::class.java)?.copy(uid = key)

fun DataSnapshot.uExpenses(): Expenses =
    getValue(Expenses::class.java)?.copy(uid = key)