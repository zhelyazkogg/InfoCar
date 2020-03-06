package com.example.infocar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class AddCarActivity : AppCompatActivity() {

    lateinit var brandRegister : EditText
    lateinit var modelRegister : EditText

    lateinit var hpRegister : EditText
    lateinit var yoursSinceRegister : EditText
    lateinit var kmRegister : EditText
    lateinit var registerNumberVehicle : EditText
    lateinit var vehicleTypeRegister : AutoCompleteTextView
    lateinit var fuelTypeRegister : AutoCompleteTextView
    lateinit var buttonRegister : Button
    lateinit var buttonBack : Button
    // TODO Buttons for Confirm

// TODO make fuelTypeRegister autocomplete Work!!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        brandRegister = findViewById(R.id.brandRegister)
        modelRegister = findViewById(R.id.modelRegister)
        hpRegister = findViewById(R.id.hpRegister)
        yoursSinceRegister = findViewById(R.id.yoursSinceRegister)
        kmRegister = findViewById(R.id.kmRegister)
        registerNumberVehicle = findViewById(R.id.registerNumberVehicle)
        buttonBack = findViewById(R.id.buttonBack)
        buttonRegister = findViewById(R.id.buttonRegister)

        fuelTypeRegister = findViewById(R.id.fuelTypeRegister)
        vehicleTypeRegister = findViewById(R.id.vehicleTypeRegister)

        var typeOfVehicle = arrayOf("Sedan", "Combi", "Hatchback", "Cabriolet")
        var adapter = ArrayAdapter(this , android.R.layout.simple_list_item_1,typeOfVehicle)
        vehicleTypeRegister.threshold=0
        vehicleTypeRegister.setAdapter(adapter)

        buttonRegister.setOnClickListener {
            val ProfileActivity = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(ProfileActivity)
            finish()
        }

        buttonBack.setOnClickListener {
            val LoginActivity = Intent(applicationContext, LoginActivity::class.java)
            startActivity(LoginActivity)
            finish()
        }
    }
}