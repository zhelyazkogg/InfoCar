package com.example.infocar.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.infocar.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.infocar.models.User
import kotlinx.android.synthetic.main.activity_add_car.buttonRegister
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mProgressBar: ProgressDialog
    private val TAG = "RegisterActivity"
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()
        mProgressBar = ProgressDialog(this)
        mDatabase = FirebaseDatabase.getInstance().reference
        buttonRegister.setOnClickListener(this)
        buttonBack.setOnClickListener(this)

    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.buttonRegister -> {
                onRegister()
            }
        }

        when(v?.id){
            R.id.buttonBack -> {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }

    private fun onRegister(){
        val email = emailRegister.text.toString()
        val password = passwordRegister.text.toString()
        val confPassword = confPasswordRegister.text.toString()

        if(email.isEmpty() || password.isEmpty() || confPassword.isEmpty()){
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            if(password.isEmpty())
                Toast.makeText(this, "Password must be atleast 6 characters", Toast.LENGTH_SHORT).show()

        } else {
            if(password == confPassword){
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val user = mkUser(email)
                        val reference = mDatabase.child("users").child(it.result?.user!!.uid)
                        reference.setValue(user).addOnCompleteListener {
                            if (it.isSuccessful){
                                Toast.makeText(this, "First Step of Registration Successful!", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this, AddCarActivity::class.java))
                                finish()
                            } else {
                                Toast.makeText(this, "Error in Sign up", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        Toast.makeText(this, "Error in Sign up", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Make sure both passwords match.", Toast.LENGTH_SHORT).show()
            }
        }
    }

        private fun mkUser(email: String): User {
            // val username = mkUsername(email)
            // TODO ^ this was the old way we will see if it works or not
            val email = mkUsername(email)
            return User(email = email)
        }

        private fun mkUsername(email: String) =
            email.replace(" ", " ")
}

/*  emailRegister = findViewById(R.id.emailRegister)
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
                        val user = mkUser(email)
                        var reference = mDatabase.child("users").child(it.result.user.uid)
                        reference.setValue(user)
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
        */
