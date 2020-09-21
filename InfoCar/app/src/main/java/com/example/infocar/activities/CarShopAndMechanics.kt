package com.example.infocar.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.infocar.R
import kotlinx.android.synthetic.main.activity_car_shop_and_mechanics.*

class CarShopAndMechanics : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_shop_and_mechanics)

        buttonBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonBack -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}