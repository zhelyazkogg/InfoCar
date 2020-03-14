package com.example.infocar

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var mProgressBar: ProgressDialog

    lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        val emailLogin = findViewById<EditText>(R.id.emailLogin)
        val passwordLogin = findViewById<EditText>(R.id.passwordLogin)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val registerBtn = findViewById<Button>(R.id.registerBtn)
        val forgottenPass = findViewById<TextView>(R.id.forgottenPass)
        mProgressBar = ProgressDialog(this)

        loginBtn.setOnClickListener {
            val email = emailLogin.text.toString().trim()
            val password = passwordLogin.text.toString().trim()

            if (TextUtils.isEmpty(email)){
                emailLogin.error = "Required."
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password)){
                passwordLogin.error = "Required."
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
            val ForgottenPasswordActivity = Intent(applicationContext, ForgottenPasswordActivity::class.java)
            startActivity(ForgottenPasswordActivity)
            finish()
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
            Toast.makeText(this, "Error in Sign In.", Toast.LENGTH_SHORT).show()
        }
            mProgressBar.dismiss()
        }
    }
}
