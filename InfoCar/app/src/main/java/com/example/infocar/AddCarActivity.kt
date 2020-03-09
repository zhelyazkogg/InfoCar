package com.example.infocar

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class AddCarActivity : AppCompatActivity() {

    lateinit var brandRegister : EditText
    lateinit var modelRegister : EditText
    lateinit var engineRegister : EditText
    lateinit var yoursSinceRegister : EditText
    lateinit var kmRegister : EditText
    lateinit var licensePlateRegister : EditText
    lateinit var vehicleTypeRegister : AutoCompleteTextView
    lateinit var fuelTypeRegister : AutoCompleteTextView
    lateinit var buttonRegister : Button
    lateinit var buttonBack : Button

    lateinit var mProgressBar: ProgressDialog
    lateinit var mAuth : FirebaseAuth
    // TODO Buttons for Confirm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        mAuth = FirebaseAuth.getInstance()
        mProgressBar = ProgressDialog(this)

        brandRegister = findViewById(R.id.brandRegister)
        modelRegister = findViewById(R.id.modelRegister)
        engineRegister = findViewById(R.id.engineRegister)
        yoursSinceRegister = findViewById(R.id.yoursSinceRegister)
        kmRegister = findViewById(R.id.kmRegister)
        licensePlateRegister = findViewById(R.id.licensePlateRegister)
        buttonBack = findViewById(R.id.buttonBack)
        buttonRegister = findViewById(R.id.buttonRegister)

        fuelTypeRegister = findViewById(R.id.fuelTypeRegister)
        vehicleTypeRegister = findViewById(R.id.vehicleTypeRegister)

        var typeOfVehicle = arrayOf("Sedan", "Combi", "Hatchback", "Coupe", "Седан", "Комби", "Хечбек", "Купе", "Друг", "Other")
        var adapter = ArrayAdapter(this , android.R.layout.simple_list_item_1,typeOfVehicle)
        vehicleTypeRegister.threshold=0
        vehicleTypeRegister.setAdapter(adapter)
        
        var typeOfFuel = arrayOf("Diesel", "Petrol", "Petrol/Gas", "Methane", "Дизел", "Бензин", "Бензин/Газ", "Метан")
        var adapterFuel = ArrayAdapter(this, android.R.layout.simple_list_item_1, typeOfFuel)
        fuelTypeRegister.threshold=1
        fuelTypeRegister.setAdapter(adapterFuel)

        buttonRegister.setOnClickListener {
            val brand = brandRegister.text.toString().trim()
            val model = modelRegister.text.toString().trim()
            val engine = engineRegister.text.toString().trim()
            val yourSince = yoursSinceRegister.text.toString().trim()
            val kilometers = kmRegister.text.toString().trim()
            val licensePlate = licensePlateRegister.text.toString().trim()
            val fuel = fuelTypeRegister.text.toString().trim()
            val vehicleType = vehicleTypeRegister.text.toString().trim()

            if (TextUtils.isEmpty(brand)){
                brandRegister.error = "Please enter your vehicle's brand."
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(model)){
                modelRegister.error = "Please enter your vehicle's model."
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(vehicleType)){
                vehicleTypeRegister.error = "Please enter your vehicle's car type."
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(engine)){
                engineRegister.error = "Please enter your vehicle's engine volume, " +
                        "plus the horsepowers."
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(yourSince)){
                yoursSinceRegister.error = "Please enter the date when you registered your vehicle."
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(fuel)){
                fuelTypeRegister.error = "Please enter your vehicle's fuel type."
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(kilometers)){
                kmRegister.error = "Please enter the current KM on your vehicle."
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(licensePlate)){
                licensePlateRegister.error = "Please enter your vehicles licence plate."
                return@setOnClickListener
            }



            /*val ProfileActivity = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(ProfileActivity)
            finish()*/
        }

        buttonBack.setOnClickListener {
            val LoginActivity = Intent(applicationContext, LoginActivity::class.java)
            startActivity(LoginActivity)
            finish()
        }
    }

    private fun createVehicleLog(){

    }
}