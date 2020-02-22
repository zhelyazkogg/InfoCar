package com.example.infocar

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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


        
    }
}
