package com.example.infocar

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.NonNull
import com.google.firebase.auth.FirebaseAuth

class ForgottenPasswordActivity : AppCompatActivity() {

    lateinit var forgottenPassSending : Button
    lateinit var forgottenPassEmail : EditText
    lateinit var forgottenPassBack : Button

    lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotten_password)
        mAuth = FirebaseAuth.getInstance()

        forgottenPassSending = findViewById(R.id.forgottenPassSending)
        forgottenPassEmail = findViewById(R.id.forgottenPassEmail)
        forgottenPassBack = findViewById(R.id.forgottenPassBack)

        forgottenPassSending.setOnClickListener {
            val email = forgottenPassEmail.text.toString().trim()

            if (TextUtils.isEmpty(email)){
                forgottenPassEmail.error = "Required."
            } else {
                mAuth!!.sendPasswordResetEmail(email)
                    .addOnCompleteListener{task ->
                        if (task.isSuccessful){
                           Toast.makeText(this@ForgottenPasswordActivity,
                               "Check email to reset your password",Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(this@ForgottenPasswordActivity,
                               "Failed to send requested password email", Toast.LENGTH_SHORT).show()
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
