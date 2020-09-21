package com.example.infocar.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.infocar.R
import com.example.infocar.models.UserCarInfo
import com.example.infocar.models.User
import com.example.infocar.utils.ValueListenerAdapter
import com.example.infocar.utils.asCarInfo
import com.example.infocar.utils.asUser
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile.buttonBack

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDatabase: DatabaseReference
    private lateinit var mUserCarInfo: UserCarInfo
    private lateinit var mUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        buttonBack.setOnClickListener(this)
        updateBtn.setOnClickListener(this)

        fun currentUserReference(): DatabaseReference =
            mDatabase.child("users").child(mAuth.currentUser!!.uid)
        currentUserReference().addListenerForSingleValueEvent(
            ValueListenerAdapter {
                mUser = it.asUser()!!
                emailOfUser.text = mUser.email
            })

        fun currentUserVehicleReference(): DatabaseReference =
            mDatabase.child("userCarInfo").child(mAuth.currentUser!!.uid)
        currentUserVehicleReference().addListenerForSingleValueEvent(
            ValueListenerAdapter {
                mUserCarInfo = it.asCarInfo()!!
                brandFirebase.text = mUserCarInfo.carBrand
                modelFirebase.text = mUserCarInfo.carModel
                vehicleTypeFirebase.text = mUserCarInfo.carType
                fuelFirebase.text = mUserCarInfo.fuelType
                engineFirebase.text = mUserCarInfo.engineVolume
                yoursSinceFirebase.text = mUserCarInfo.dateOfRegister
                kmFirebase.text = mUserCarInfo.kilometersPassed
                licensePlateFirebase.text = mUserCarInfo.licensePlateNumber
            }
        )
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonBack -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }

        when (v?.id) {
            R.id.updateBtn -> {
                startActivity(Intent(this, UpdateDataActivity::class.java))
            }
        }
    }
}