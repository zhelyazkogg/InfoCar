package com.example.infocar

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth

class ForgottenPasswordActivity : AppCompatActivity() {

    lateinit var forgottenPassSending : Button
    lateinit var forgottenPassEmail : EditText
    lateinit var forgottenPassBack : Button
    lateinit var mProgressBar: ProgressDialog

    lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotten_password)
        mAuth = FirebaseAuth.getInstance()

        forgottenPassSending = findViewById(R.id.forgottenPassSending)
        forgottenPassEmail = findViewById(R.id.forgottenPassEmail)
        forgottenPassBack = findViewById(R.id.forgottenPassBack)

    }
}
