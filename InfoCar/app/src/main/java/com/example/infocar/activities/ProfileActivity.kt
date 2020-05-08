package com.example.infocar.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.infocar.R
import com.example.infocar.models.CarInfo
import com.example.infocar.models.User
import com.example.infocar.utils.ValueListenerAdapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mAuth : FirebaseAuth
    private lateinit var mDatabase: DatabaseReference
    private lateinit var uCarInfo: CarInfo
    private lateinit var mUser: User


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        logoutButton.setOnClickListener(this)

        fun currentUserReference(): DatabaseReference =
            mDatabase.child("users").child(mAuth.currentUser!!.uid)
        currentUserReference().addListenerForSingleValueEvent(
            ValueListenerAdapter{
            mUser = it.asUser()!!
            emailOfUser.setText(mUser.email)
        })
/*
        val brandFirebase = findViewById<EditText>(R.id.brandFirebase)
        val modelFirebase = findViewById<EditText>(R.id.modelFirebase)
        val vehicleTypeFirebase = findViewById<EditText>(R.id.vehicleTypeFirebase)
        val fuelFirebase = findViewById<EditText>(R.id.fuelFirebase)
        val engineFirebase = findViewById<EditText>(R.id.engineFirebase)
        val yoursSinceFirebase = findViewById<EditText>(R.id.yoursSinceFirebase)
        val kmFirebase = findViewById<EditText>(R.id.kmFirebase)
        val licensePlateFirebase = findViewById<EditText>(R.id.licensePlateFirebase)*/
    }

    // Logout button doesn't erase the storage/cache and doesn't logout.
    override fun onClick(view: View) {
        when(view.id){
            R.id.logoutButton -> {
                mAuth.signOut()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }
}
