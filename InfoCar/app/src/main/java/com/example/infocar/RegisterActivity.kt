package com.example.infocar

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    lateinit var emailRegister : EditText
    lateinit var passwordRegister : EditText
    lateinit var confPasswordRegister : EditText
    lateinit var buttonRegister : Button
    lateinit var buttonBack : Button
    lateinit var mProgressBar: ProgressDialog
    lateinit var mAuth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        mProgressBar = ProgressDialog(this)

        emailRegister = findViewById(R.id.emailRegister)
        passwordRegister = findViewById(R.id.passwordRegister)
        confPasswordRegister = findViewById(R.id.confPasswordRegister)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonBack = findViewById(R.id.buttonBack)


        buttonRegister.setOnClickListener {
            val email = emailRegister.text.toString().trim()
            val password = passwordRegister.text.toString().trim()
            val confirmPassword = confPasswordRegister.text.toString().trim()

            if (TextUtils.isEmpty(email)){
                emailRegister.error = "Please enter e-mail"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(password)){
                passwordRegister.error = "Please enter password"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(confirmPassword)){
                confPasswordRegister.error = "Please confirm password"
                return@setOnClickListener
            }
        }

        buttonBack.setOnClickListener {
            val LoginActivity = Intent(applicationContext, LoginActivity::class.java)
            startActivity(LoginActivity)
            finish()
        }
    }
}
