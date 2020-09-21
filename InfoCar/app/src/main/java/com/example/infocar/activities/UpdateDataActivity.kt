package com.example.infocar.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.infocar.R

class UpdateDataActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_data)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonBack -> {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
        }
    }
}