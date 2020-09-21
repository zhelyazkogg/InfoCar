package com.example.infocar.activities

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.infocar.R
import com.example.infocar.models.Expenses
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_expenses.*

class ExpensesActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mProgressBar: ProgressDialog
    private val TAG = "ExpensesActivity"
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDatabase: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses)

        mAuth = FirebaseAuth.getInstance()
        mProgressBar = ProgressDialog(this)
        mDatabase = FirebaseDatabase.getInstance().reference

        addExpense.setOnClickListener(this)
        buttonBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.addExpense -> {
                onAddExpense()
            }
        }

        when (v?.id) {
            R.id.buttonBack -> {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
    }

    private fun onAddExpense() {
        val title = titleExpense.text.toString()
        val date = dateExpense.text.toString()
        val amount = amountExpense.text.toString()
        val description = descriptionExpense.text.toString()

        if (title.isEmpty() || date.isEmpty() || amount.isEmpty()) {
            Toast.makeText(this, "Title, Date and Amount fields are required!", Toast.LENGTH_SHORT)
                .show()
        } else {
            val expenses = Expenses(title, date, amount, description)

            mDatabase.child("userExpenses").child(mAuth.currentUser!!.uid).setValue(expenses)
                .addOnSuccessListener {
                    Toast.makeText(
                        this, "Expense added", Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(this, ProfileActivity::class.java))
                    finish()
                }
                .addOnFailureListener {
                    Toast.makeText(
                        this, "Failed to add expense", Toast.LENGTH_SHORT
                    ).show()
                }
        }
    }
}