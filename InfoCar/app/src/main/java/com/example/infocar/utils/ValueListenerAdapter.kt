package com.example.infocar.utils

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class ValueListenerAdapter(val handler: (DataSnapshot) -> Unit): ValueEventListener {

    private val TAG = "ValueListenerAdapter"

    override fun onCancelled(error: DatabaseError) {
        Log.e("onCancelled", TAG, error.toException())
    }

    override fun onDataChange(data: DataSnapshot) {
        handler(data)
    }
}