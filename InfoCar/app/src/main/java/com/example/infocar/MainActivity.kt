package com.example.infocar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG = "MainActivity"
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        /*val myProfileActivity = findViewById<TextView>(R.id.myProfileActivity)
        val myFuelActivity = findViewById<TextView>(R.id.myFuelActivity)
        val myMapActivity = findViewById<TextView>(R.id.myMapActivity)
        val myLawActivity = findViewById<TextView>(R.id.myLawActivity)
        val myShopActivity = findViewById<TextView>(R.id.myShopActivity)
        val mySettingsActivity = findViewById<TextView>(R.id.mySettingsActivity)*/

        myProfileActivity.setOnClickListener(this)
        myFuelActivity.setOnClickListener(this)
        myMapActivity.setOnClickListener(this)
        myLawActivity.setOnClickListener(this)
        myShopActivity.setOnClickListener(this)
        mySettingsActivity.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.myProfileActivity
        }
    }

}




