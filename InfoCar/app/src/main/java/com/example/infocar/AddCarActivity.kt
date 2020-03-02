package com.example.infocar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner

class AddCarActivity : AppCompatActivity() {

    lateinit var brandRegister : EditText
    lateinit var modelRegister : EditText
    lateinit var vehicleYearRegister : EditText
    lateinit var hpRegister : EditText
    lateinit var yoursSinceRegister : EditText
    lateinit var kmRegister : EditText
    lateinit var registerNumberVehicle : EditText
    internal lateinit var vehicleTypeRegister : Spinner
    lateinit var fuelTypeRegister : Spinner // TODO

    // TODO Buttons for Back and Confirm



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        brandRegister = findViewById(R.id.brandRegister)
        modelRegister = findViewById(R.id.modelRegister)
        vehicleYearRegister = findViewById(R.id.vehicleYearRegister)
        hpRegister = findViewById(R.id.hpRegister)
        yoursSinceRegister = findViewById(R.id.yoursSinceRegister)
        kmRegister = findViewById(R.id.kmRegister)
        registerNumberVehicle = findViewById(R.id.registerNumberVehicle)
        vehicleTypeRegister = findViewById<Spinner>(R.id.vehicleTypeRegister)
            val vehicleType = arrayOf("Sedan", "Coupe", "Cabriolet", "Hatchback", "Wagon", "Van", "SUV", "Other")
            vehicleTypeRegister.adapter
    }
}
