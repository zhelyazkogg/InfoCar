package com.example.infocar.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.infocar.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG = "MainActivity"
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        myProfileActivity.setOnClickListener(this)
        myExpensesActivity.setOnClickListener(this)
        myMapActivity.setOnClickListener(this)
        myLawActivity.setOnClickListener(this)
        myShopActivity.setOnClickListener(this)
        mySettingsActivity.setOnClickListener(this)
        myShopActivity.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.myProfileActivity -> {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
        }
        when (v.id) {
            R.id.myExpensesActivity -> {
                startActivity(Intent(this, ExpensesActivity::class.java))
            }
        }
        when (v.id) {
            R.id.myMapActivity -> {
                startActivity(Intent(this, NearbyPetrolStation::class.java))
            }
        }
        when (v.id) {
            R.id.myLawActivity -> {
                startActivity(Intent(this, LawActivity::class.java))
            }
        }
        when (v.id) {
            R.id.myShopActivity -> {
            startActivity(Intent(this, CarShopAndMechanics::class.java))
            }
        }
        when (v.id) {
            R.id.mySettingsActivity -> {
            startActivity(Intent(this, SettingsActivity::class.java))
            }
        }
    }
}