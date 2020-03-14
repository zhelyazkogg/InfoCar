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
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    lateinit var mProgressBar: ProgressDialog
    lateinit var mAuth : FirebaseAuth

 // TODO validate ConfirmPassword... or remove confirm password..

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        mProgressBar = ProgressDialog(this)

        val emailRegister = findViewById<EditText>(R.id.emailRegister)
        val passwordRegister = findViewById<EditText>(R.id.passwordRegister)
        //confPasswordRegister = findViewById(R.id.confPasswordRegister)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)
        val buttonBack = findViewById<Button>(R.id.buttonBack)


        buttonRegister.setOnClickListener {
            val email = emailRegister.text.toString().trim()
            val password = passwordRegister.text.toString().trim()
//            val confirmPassword = confPasswordRegister.text.toString().trim()

            if (TextUtils.isEmpty(email)){
                emailRegister.error = "Please enter a valid e-mail."
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(password)){
                passwordRegister.error = "Password must be minimum 6 symbols"
                return@setOnClickListener
            }
            /*if (TextUtils.isEmpty(confirmPassword)){
                confPasswordRegister.error = "Required."
                return@setOnClickListener
            }

            if (!confirmPassword.equals(password)){
                confPasswordRegister.error = "Password doesn't match."
            }*/

            validateForm(email, password)
        }

        buttonBack.setOnClickListener {
            val LoginActivity = Intent(applicationContext, LoginActivity::class.java)
            startActivity(LoginActivity)
            finish()
        }
    }

    private fun  validateForm(email : String, password : String){
        mProgressBar.setMessage("Please wait")
        mProgressBar.show()

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this){task ->
            if (task.isSuccessful){
                val intent = Intent(applicationContext, AddCarActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Error in Sign up", Toast.LENGTH_SHORT).show()
            }
            mProgressBar.dismiss()
        }
    }
}