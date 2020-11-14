package com.example.infocar.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.infocar.R
import com.example.infocar.models.Expenses
import com.example.infocar.models.UserCarInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_car.*

class AddCarActivity() : AppCompatActivity(), View.OnClickListener {

    lateinit var mProgressBar: ProgressDialog
    private val TAG = "AddCarActivity"
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDatabase: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        mAuth = FirebaseAuth.getInstance()
        mProgressBar = ProgressDialog(this)
        mDatabase = FirebaseDatabase.getInstance().reference

        buttonRegister.setOnClickListener(this)
        buttonBack.setOnClickListener(this)

        val typeOfVehicle = arrayOf(
            "Sedan",
            "Wagon",
            "Hatchback",
            "Compact",
            "Coupe",
            "Седан",
            "Комби",
            "Хечбек",
            "Компакт",
            "Купе",
            "Друг",
            "Other"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, typeOfVehicle)
        vehicleTypeRegister.threshold = 0
        vehicleTypeRegister.setAdapter(adapter)

        val typeOfFuel = arrayOf(
            "Electric",
            "Diesel",
            "Petrol",
            "Petrol/Natural Gas",
            "Methane",
            "Ток",
            "Дизел",
            "Бензин",
            "Бензин/Газ",
            "Метан"
        )
        val adapterFuel = ArrayAdapter(this, android.R.layout.simple_list_item_1, typeOfFuel)
        fuelTypeRegister.threshold = 1
        fuelTypeRegister.setAdapter(adapterFuel)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonRegister -> {
                onRegister()
            }
        }

        when (v?.id) {
            R.id.buttonBack -> {
                startActivity(Intent(this, RegisterActivity::class.java))
            }
        }
    }
//
//    private fun onRegister(){
//
//    }

    private fun onRegister() {
        val brand = brandRegister.text.toString()
        val model = modelRegister.text.toString()
        val carType = vehicleTypeRegister.text.toString()
        val fuelType = fuelTypeRegister.text.toString()
        val engineVolume = engineRegister.text.toString()
        val vehicleRegister = yoursSinceRegister.text.toString()
        val kilometers = kmRegister.text.toString()
        val plateNumber = licensePlateRegister.text.toString()

        if (brand.isEmpty() || model.isEmpty() || carType.isEmpty() || engineVolume.isEmpty()
            || vehicleRegister.isEmpty() || fuelType.isEmpty() || kilometers.isEmpty()
            || plateNumber.isEmpty()
        ) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
        } else {
            val carInfo = UserCarInfo(
                brand, model, carType, fuelType, engineVolume, vehicleRegister,
                kilometers, plateNumber
            )
            val addExpense = Expenses(title = "0", date = "0", amount = "0", description = "0")
            mDatabase.child("userCarInfo").child(mAuth.currentUser!!.uid).setValue(carInfo)
                .addOnSuccessListener {
                    Toast.makeText(
                        this, "Congratulations and Hello to InfoCar!", Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Error in Sign up", Toast.LENGTH_SHORT).show()
                }
            mDatabase.child("userExpenses").child(mAuth.currentUser!!.uid).setValue(addExpense)
                .addOnSuccessListener {
                    startActivity(Intent(this, MainActivity::class.java))
                }
        }
    }
}