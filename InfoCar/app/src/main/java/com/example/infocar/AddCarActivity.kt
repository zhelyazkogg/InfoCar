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
    lateinit var vehicleTypeRegister : EditText
    //  lateinit var vehicleTypeRegister : AutoCompleteTextView
    lateinit var fuelTypeRegister : EditText
    lateinit var buttonRegister : Button
    lateinit var buttonBack : Button
    // TODO Buttons for Confirm



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        brandRegister = findViewById(R.id.brandRegister)
        modelRegister = findViewById(R.id.modelRegister)
        hpRegister = findViewById(R.id.hpRegister)
        yoursSinceRegister = findViewById(R.id.yoursSinceRegister)
        kmRegister = findViewById(R.id.kmRegister)
        registerNumberVehicle = findViewById(R.id.registerNumberVehicle)
        vehicleTypeRegister = findViewById(R.id.vehicleTypeRegister)
        fuelTypeRegister = findViewById(R.id.fuelTypeRegister)
        buttonBack = findViewById(R.id.buttonBack)
        buttonRegister = findViewById(R.id.buttonRegister)

       /* val vehicleTypeRegister = findViewById<AutoCompleteTextView>(R.id.vehicleTypeRegister)
        val vehicleTypeMenuRegister = resources.getStringArray(R.array.vehicleTypeMenu)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, vehicleTypeMenuRegister)
        vehicleTypeRegister.setAdapter(adapter)

        val button = findViewById<Button>(R.id.buttonRegister)
        if (button != null) {
            button ?.setOnClickListener { v ->
                val enteredText = getString(R.string.submitted_lang) + "" + vehicleTypeRegister.getText()
                Toast.makeText(this@AddCarActivity,enteredText, Toast.LENGTH_SHORT).show()
            }
        }*/

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
