package com.example.infocar.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.infocar.R
import com.example.infocar.models.User
import com.example.infocar.models.UserCarInfo
import com.example.infocar.utils.ValueListenerAdapter
import com.example.infocar.utils.asCarInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_update_data.*
import kotlinx.android.synthetic.main.activity_update_data.buttonBack
import kotlinx.android.synthetic.main.activity_update_data.view.*

class UpdateDataActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDatabase: DatabaseReference
    private lateinit var mUserCarInfo: UserCarInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)

        mAuth = FirebaseAuth.getInstance()
        mDatabase = FirebaseDatabase.getInstance().reference
        buttonUpdate.setOnClickListener(this)
        buttonBack.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonUpdate -> {
                updateInfo()
            }
        }

        when (v?.id) {
            R.id.buttonBack -> {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
        }
    }

    private fun updateInfo() {
        val brand = brandUpdate.text.toString()
        val model = modelUpdate.text.toString()
        val carType = vehicleTypeUpdate.text.toString()
        val fuelType = fuelTypeUpdate.text.toString()
        val engineVolume = engineUpdate.text.toString()
        val yoursSince = yoursSinceUpdate.text.toString()
        val kmUpdate = kmUpdate.text.toString()
        val plateNumber = licensePlateUpdate.text.toString()

        if (brand.isEmpty() || model.isEmpty() || carType.isEmpty() || engineVolume.isEmpty()
            || yoursSince.isEmpty() || fuelType.isEmpty() || kmUpdate.isEmpty()
            || plateNumber.isEmpty()
        ) {
            Toast.makeText(this, "All fields are required.", Toast.LENGTH_SHORT).show()
        } else {
            val carInfo = UserCarInfo(
                brand, model, carType, fuelType, engineVolume, yoursSince,
                kmUpdate, plateNumber
            )
            mDatabase.child("userCarInfo").child(mAuth.currentUser!!.uid).setValue(carInfo)
                .addOnSuccessListener {
                    Toast.makeText(
                        this, "Successfully Updated!", Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this, ProfileActivity::class.java))
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Unsuccessful update.", Toast.LENGTH_SHORT).show()
                }
        }
    }

}