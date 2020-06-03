package com.example.infocar.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.infocar.R
import com.google.firebase.auth.FirebaseAuth

class ForgottenPasswordActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotten_password)
        mAuth = FirebaseAuth.getInstance()

        val forgottenPassSending = findViewById<Button>(R.id.forgottenPassSending)
        val forgottenPassEmail = findViewById<EditText>(R.id.forgottenPassEmail)
        val forgottenPassBack = findViewById<Button>(R.id.forgottenPassBack)

        forgottenPassSending.setOnClickListener {
            val email = forgottenPassEmail.text.toString().trim()

            if (TextUtils.isEmpty(email)) {
                forgottenPassEmail.error = "Required."
            } else {
                mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(
                                this@ForgottenPasswordActivity,
                                "Check email to reset your password", Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                this@ForgottenPasswordActivity,
                                "Failed to send requested password email", Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }

        forgottenPassBack.setOnClickListener {
            val LoginActivity = Intent(applicationContext, LoginActivity::class.java)
            startActivity(LoginActivity)
            finish()
        }

    }
}
