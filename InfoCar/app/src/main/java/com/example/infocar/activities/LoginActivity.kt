package com.example.infocar.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.infocar.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private val TAG = "LoginActivity"
    lateinit var mProgressBar: ProgressDialog
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        loginBtn.setOnClickListener(this)
        registerBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.loginBtn -> {
                val email = emailLogin.text.toString()
                val password = passwordLogin.text.toString()

                if (validateForm(email, password)) {
                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(this, "incorrect email or password", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Please enter email and/or password", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        when (v?.id) {
            R.id.registerBtn -> {
                startActivity(Intent(this, RegisterActivity::class.java))
            }
        }
    }

    private fun validateForm(email: String, password: String) =
        email.isNotEmpty() && password.isNotEmpty()
}


/* val emailLogin = findViewById<EditText>(R.id.emailLogin)
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
            val startIntent = Intent(applicationContext, MainActivity::class.java)
            startActivity(startIntent)
            finish()
        } else {
            Toast.makeText(this, "Error in Sign In.", Toast.LENGTH_SHORT).show()
        }
            mProgressBar.dismiss()
        }*/