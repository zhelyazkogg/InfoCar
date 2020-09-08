package com.example.infocar.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.infocar.R
import com.example.infocar.models.CarInfo
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
            "Natural Gas/Petrol",
            "Methane",
            "Ток",
            "Дизел",
            "Бензин",
            "Бензин/Газ",
            "Газ/Бензин",
            "Метан"
        )
        val adapterFuel = ArrayAdapter(this, android.R.layout.simple_list_item_1, typeOfFuel)
        fuelTypeRegister.threshold = 1
        fuelTypeRegister.setAdapter(adapterFuel)

        /*fun currentUserReference(): DatabaseReference =
            mDatabase.child("users").child(mAuth.currentUser!!.uid)*/
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

    private fun onRegister() {
        val brand = brandRegister.text.toString()
        val model = modelRegister.text.toString()
        val carType = vehicleTypeRegister.text.toString()
        val engineVolume = engineRegister.text.toString()
        val vehicleRegister = yoursSinceRegister.text.toString()
        val fuelType = fuelTypeRegister.text.toString()
        val kilometers = kmRegister.text.toString()
        val plateNumber = licensePlateRegister.text.toString()

        if (brand.isEmpty() || model.isEmpty() || carType.isEmpty() || engineVolume.isEmpty()
            || vehicleRegister.isEmpty() || fuelType.isEmpty() || kilometers.isEmpty()
            || plateNumber.isEmpty()
        ) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
        } else {
            val carInfo = CarInfo(
                brand, model, carType, engineVolume, vehicleRegister,
                fuelType, kilometers, plateNumber
            )
            mDatabase.child("carInfo").child(mAuth.currentUser!!.uid).setValue(carInfo)
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
        }
    }
}
/*   private fun userDetails(carBrand: String, carModel: String,
       carType: String, fuelType: String, engineVolume: String, dateOfRegester: String
       kilometersPassed: String, licensePlateNumber: String): CarInfo{
           return(brand = carBrand)
       }*//*
}*/

/*val brandRegister = findViewById<EditText>(R.id.brandRegister)
val modelRegister = findViewById<EditText>(R.id.modelRegister)
val engineRegister = findViewById<EditText>(R.id.engineRegister)
val yoursSinceRegister = findViewById<EditText>(R.id.yoursSinceRegister)
val kmRegister = findViewById<EditText>(R.id.kmRegister)
val licensePlateRegister = findViewById<EditText>(R.id.licensePlateRegister)
val buttonBack = findViewById<Button>(R.id.buttonBack)
val buttonRegister = findViewById<Button>(R.id.buttonRegister)
val fuelTypeRegister = findViewById<AutoCompleteTextView>(R.id.fuelTypeRegister)
val vehicleTypeRegister = findViewById<AutoCompleteTextView>(R.id.vehicleTypeRegister)
buttonRegister.setOnClickListener {
    val brand = brandRegister.text.toString().trim()
    val model = modelRegister.text.toString().trim()
    val engine = engineRegister.text.toString().trim()
    val yourSince = yoursSinceRegister.text.toString().trim()
    val kilometers = kmRegister.text.toString().trim()
    val licensePlate = licensePlateRegister.text.toString().trim()
    val fuel = fuelTypeRegister.text.toString().trim()
    val vehicleType = vehicleTypeRegister.text.toString().trim()
    if (TextUtils.isEmpty(brand)) {
        brandRegister.error = "Please enter your vehicle's brand."
        return@setOnClickListener
    }
    if (TextUtils.isEmpty(model)) {
        modelRegister.error = "Please enter your vehicle's model."
        return@setOnClickListener
    }
    if (TextUtils.isEmpty(vehicleType)) {
        vehicleTypeRegister.error = "Please enter your vehicle's car type."
        return@setOnClickListener
    }
    if (TextUtils.isEmpty(engine)) {
        engineRegister.error = "Please enter your vehicle's engine volume, " +
                "plus the horsepowers."
        return@setOnClickListener
    }
    if (TextUtils.isEmpty(yourSince)) {
        yoursSinceRegister.error = "Please enter the date when you registered your vehicle."
        return@setOnClickListener
    }
    if (TextUtils.isEmpty(fuel)) {
        fuelTypeRegister.error = "Please enter your vehicle's fuel type."
        return@setOnClickListener
    }
    if (TextUtils.isEmpty(kilometers)) {
        kmRegister.error = "Please enter the current KM on your vehicle."
        return@setOnClickListener
    }
    if (TextUtils.isEmpty(licensePlate)) {
        licensePlateRegister.error = "Please enter your vehicles licence plate."
        return@setOnClickListener
    }
    val ProfileActivity = Intent(applicationContext, ProfileActivity::class.java)
    startActivity(ProfileActivity)
    finish()
}
buttonBack.setOnClickListener {
    val LoginActivity = Intent(applicationContext, LoginActivity::class.java)
    startActivity(LoginActivity)
    finish()
}*/