package com.example.infocar

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import models.User

class RegisterActivity : AppCompatActivity() {

    lateinit var mProgressBar: ProgressDialog
    lateinit var emailRegister : EditText
    lateinit var passwordRegister : EditText

 //   lateinit var firebaseUser : FirebaseUser
    lateinit var DBinstance : FirebaseFirestore
    lateinit var database : DatabaseReference

    private val TAG = "RegisterActivity"
    private lateinit var mAuth : FirebaseAuth

 // TODO validate ConfirmPassword... or remove confirm password..

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        DBinstance = FirebaseFirestore.getInstance()
        mProgressBar = ProgressDialog(this)
        database = FirebaseDatabase.getInstance().reference

        emailRegister = findViewById(R.id.emailRegister)
        passwordRegister = findViewById(R.id.passwordRegister)
        //confPasswordRegister = findViewById(R.id.confPasswordRegister)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)
        val buttonBack = findViewById<Button>(R.id.buttonBack)


        buttonRegister.setOnClickListener {
            val email = emailRegister.text.toString().trim()
            val password = passwordRegister.text.toString().trim()

            if (validateForm()) {
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            val intent = Intent(applicationContext, AddCarActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else {
                            Toast.makeText(this, "Error in Sign up", Toast.LENGTH_SHORT).show()
                        }
                        mProgressBar.dismiss()
                    }
                mProgressBar.setMessage("Please wait")
                mProgressBar.show()  // TODO dont forget about this.
            } else {
                Toast.makeText(this, "Error in Sign up", Toast.LENGTH_SHORT).show()
            }
            mProgressBar.dismiss()

        }

        buttonBack.setOnClickListener {
            val LoginActivity = Intent(applicationContext, LoginActivity::class.java)
            startActivity(LoginActivity)
            finish()

        }
    }
    fun addUser(){
        val user = User.create()

     //   user.email = txtNewTaskDesc.text.toString()
    }

    private fun  validateForm() : Boolean{
        val email = emailRegister.text.toString()
        val password = passwordRegister.text.toString()

        if (TextUtils.isEmpty(email)){
            emailRegister.error = "Please enter a valid e-mail."
        }
        if (TextUtils.isEmpty(password)){
            passwordRegister.error = "Password must be minimum 6 symbols"
        }
        return true
    }
}