package com.example.infocar.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
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

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDatabase: DatabaseReference
    private lateinit var mCarInfo: CarInfo
    private lateinit var mUser: User


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        logoutButton.setOnClickListener(this)
        buttonBack.setOnClickListener(this)

        fun currentUserReference(): DatabaseReference =
            mDatabase.child("users").child(mAuth.currentUser!!.uid)
        currentUserReference().addListenerForSingleValueEvent(
            ValueListenerAdapter {
                mUser = it.asUser()!!
                emailOfUser.text = mUser.email
            })

        fun currentUserVehicleReference(): DatabaseReference =
            mDatabase.child("carInfo").child(mAuth.currentUser!!.uid)
        currentUserVehicleReference().addListenerForSingleValueEvent(
            ValueListenerAdapter {
                mCarInfo = it.asCarInfo()!!
                brandFirebase.text = mCarInfo.carBrand
                modelFirebase.text = mCarInfo.carModel
                vehicleTypeFirebase.text = mCarInfo.carType
                fuelFirebase.text = mCarInfo.fuelType
                engineFirebase.text = mCarInfo.engineVolume
                yoursSinceFirebase.text = mCarInfo.dateOfRegister
                kmFirebase.text = mCarInfo.kilometersPassed
                licensePlateFirebase.text = mCarInfo.licensePlateNumber
            }
        )
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.logoutButton -> {
                mAuth.signOut()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
        when (view.id) {
            R.id.buttonBack -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }
}