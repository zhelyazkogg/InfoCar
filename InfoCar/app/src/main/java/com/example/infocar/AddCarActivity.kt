package com.example.infocar

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.text.TextUtils
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class AddCarActivity() : AppCompatActivity(), View.OnClickListener {

    lateinit var mProgressBar: ProgressDialog
    private val TAG="AddCarActivity"
    private  lateinit var mAuth : FirebaseAuth

    constructor(parcel: Parcel) : this() {

    }
    // TODO Buttons for Confirm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_car)

        mAuth = FirebaseAuth.getInstance()
        mProgressBar = ProgressDialog(this)

        val brandRegister = findViewById<EditText>(R.id.brandRegister)
        val modelRegister = findViewById<EditText>(R.id.modelRegister)
        val engineRegister = findViewById<EditText>(R.id.engineRegister)
        val yoursSinceRegister = findViewById<EditText>(R.id.yoursSinceRegister)
        val kmRegister = findViewById<EditText>(R.id.kmRegister)
        val licensePlateRegister = findViewById<EditText>(R.id.licensePlateRegister)
        val buttonBack = findViewById<Button>(R.id.buttonBack)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)

        val fuelTypeRegister = findViewById<AutoCompleteTextView>(R.id.fuelTypeRegister)
        val vehicleTypeRegister = findViewById<AutoCompleteTextView>(R.id.vehicleTypeRegister)

        val typeOfVehicle = arrayOf(
            "Sedan",
            "Combi",
            "Hatchback",
            "Coupe",
            "Седан",
            "Комби",
            "Хечбек",
            "Купе",
            "Друг",
            "Other"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, typeOfVehicle)
        vehicleTypeRegister.threshold = 0
        vehicleTypeRegister.setAdapter(adapter)

        val typeOfFuel = arrayOf(
            "Diesel",
            "Petrol",
            "Petrol/Gas",
            "Gas/Petrol",
            "Methane",
            "Дизел",
            "Бензин",
            "Бензин/Газ",
            "Газ/Бензин",
            "Метан"
        )
        val adapterFuel = ArrayAdapter(this, android.R.layout.simple_list_item_1, typeOfFuel)
        fuelTypeRegister.threshold = 1
        fuelTypeRegister.setAdapter(adapterFuel)

/*        buttonRegister.setOnClickListener {
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



            *//*val ProfileActivity = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(ProfileActivity)
            finish()*//*
        }

        buttonBack.setOnClickListener {
            val LoginActivity = Intent(applicationContext, LoginActivity::class.java)
            startActivity(LoginActivity)
            finish()
        }
    }

    private fun createVehicleLog(){

        }*/
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}