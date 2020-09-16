package com.example.infocar.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.infocar.R
import com.example.infocar.models.Reminders
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_expenses.*
import kotlinx.android.synthetic.main.activity_expenses.buttonBack
import kotlinx.android.synthetic.main.activity_notification.*

class NotificationActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mProgressBar: ProgressDialog
    private val TAG = "NotificationActivity"
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        mAuth = FirebaseAuth.getInstance()
        mProgressBar = ProgressDialog(this)
        mDatabase = FirebaseDatabase.getInstance().reference

        addNotification.setOnClickListener(this)
        buttonBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.addNotification -> {
                onAddNotification()
            }
        }

        when (v?.id) {
            R.id.buttonBack -> {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
        }
    }

    private fun onAddNotification() {
        val title = titleNotification.text.toString()
        // val date = setDateNotification. нещо си
        val description = descriptionNotification.text.toString()

//        if (title.isEmpty() || date.isEmpty()){
//            Toast.makeText(this, "Title and Date fields are required", Toast.LENGTH_SHORT).show()
//        } else {
//            val reminders = Reminders(title, date, description)
//        }
    }
}