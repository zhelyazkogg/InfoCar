package com.example.infocar.utils

import android.content.Context
import android.widget.Toast
import com.example.infocar.models.UserCarInfo
import com.example.infocar.models.Expenses
import com.example.infocar.models.Reminders
import com.example.infocar.models.User
import com.google.firebase.database.DataSnapshot

fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this,text,duration).show()
}

fun DataSnapshot.asUser(): User? =
    getValue(User::class.java)?.copy(uid = key)

fun DataSnapshot.asCarInfo(): UserCarInfo? =
    getValue(UserCarInfo::class.java)?.copy(uid = key)

fun DataSnapshot.asExpenses(): Expenses? =
    getValue(Expenses::class.java)?.copy(uid = key)

fun DataSnapshot.asReminders(): Reminders? =
    key?.let { getValue(Reminders::class.java)?.copy(uid = it) }