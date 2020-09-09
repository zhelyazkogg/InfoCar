package com.example.infocar.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.infocar.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        mAuth = FirebaseAuth.getInstance()

        val changePassEmail = findViewById<EditText>(R.id.changePassEmail)
        btnBack.setOnClickListener(this)
        logoutButton.setOnClickListener(this)

        changePassSendBtn.setOnClickListener {
            val email = changePassEmail.text.toString().trim()

            if (TextUtils.isEmpty(email)) {
                changePassEmail.error = "Write down the email with which you registered."
            } else {
                mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                this@SettingsActivity,
                                "Check email to reset your password", Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                this@SettingsActivity,
                                "Failed to send requested password email", Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.logoutButton -> {
                mAuth.signOut()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        when (v?.id) {
            R.id.btnBack -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }
}

