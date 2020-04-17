package com.example.infocar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myProfile = findViewById<TextView>(R.id.myProfileActivity)
        val myFuelActivity = findViewById<TextView>(R.id.myFuelActivity)
        val myMapActivity = findViewById<TextView>(R.id.myMapActivity)
        val myLawActivity = findViewById<TextView>(R.id.myLawActivity)
        val myShopActivity = findViewById<TextView>(R.id.myShopActivity)
        val mySettingsActivity = findViewById<TextView>(R.id.mySettingsActivity)

        myProfileActivity.setOnClickListener(View.OnClickListener { v ->
            val ProfileActivity = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(ProfileActivity)
            finish()
        })
/*
        myFuelActivity.setOnClickListener(View.OnClickListener { v ->
            val FuelActivity = Intent(applicationContext, FuelActivity::class.java)
            startActivity(FuelActivity)
            finish()
        })

        myMapActivity.setOnClickListener(View.OnClickListener { v ->
            val MapActivity = Intent(applicationContext, MapActivity::class.java)
            startActivity(MapActivity)
            finish()
        })
*/
        myLawActivity.setOnClickListener(View.OnClickListener { v ->
            val LawActivity = Intent(applicationContext, LawActivity::class.java)
            startActivity(LawActivity)
            finish()
        })
/*
        myShopActivity.setOnClickListener(View.OnClickListener { v ->
            val ShopActivity = Intent(applicationContext, ShopActivity::class.java)
            startActivity(ShopActivity)
            finish()
        })

        mySettingsActivity.setOnClickListener(View.OnClickListener { v ->
            val SettingsActivity = Intent(applicationContext, SettingsActivity::class.java)
            startActivity(SettingsActivity)
            finish()
        })
 */
    }
}
