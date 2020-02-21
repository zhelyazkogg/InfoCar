package com.example.infocar

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var emailLogin : EditText
    lateinit var passwordLogin : EditText
    lateinit var loginBtn : Button
    lateinit var registerBtn : Button
    lateinit var forgottenPass : TextView
    lateinit var mProgressBar: ProgressDialog

    lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance();

        emailLogin = findViewById(R.id.emailLogin)
        passwordLogin = findViewById(R.id.passwordLogin)
        loginBtn = findViewById(R.id.loginBtn)
        registerBtn = findViewById(R.id.registerBtn)
        forgottenPass = findViewById(R.id.forgottenPass)
        mProgressBar = ProgressDialog(this)

        loginBtn.setOnClickListener {
            val email = emailLogin.text.toString().trim()
            val password = passwordLogin.text.toString().trim()

            if (TextUtils.isEmpty(email)){
                emailLogin.error = "Enter Email"
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password)){
                passwordLogin.error = "Enter Password"
                return@setOnClickListener
            }

            validateForm(email, password)
        }

        registerBtn.setOnClickListener {
            val RegisterActivity = Intent(applicationContext,RegisterActivity::class.java)
            startActivity(RegisterActivity)
            finish()
        }

        forgottenPass.setOnClickListener {
            
        }
    }

    private fun validateForm(email : String, password : String){
        mProgressBar.setMessage("Please wait")
        mProgressBar.show()

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){task ->
        if (task.isSuccessful){
            mProgressBar.dismiss()
            val startIntent = Intent(applicationContext, ProfileActivity::class.java)
            startActivity(startIntent)
            finish()
        } else {
            Toast.makeText(this, "Error is SignUp.${task.exception}", Toast.LENGTH_SHORT).show()
        }
            mProgressBar.dismiss()
        }
    }
}
