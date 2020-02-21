package com.example.infocar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    lateinit var emailLogin : EditText
    lateinit var passwordLogin : EditText
    lateinit var loginBtn : Button
    lateinit var registerBtn : Button
    lateinit var forgottenPass : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        
    }
}
