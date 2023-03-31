package com.example.mediwheelapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mediwheelapp.R

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var progressLayout: ConstraintLayout
    lateinit var imgback: ImageView
    lateinit var tvTitle: TextView
    lateinit var btncChangepass: Button
    lateinit var etEmaildId: EditText
    lateinit var etUserName: EditText
    lateinit var btnProcess: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        progressLayout = findViewById(R.id.progressLayout)
        tvTitle = findViewById(R.id.tvTitle)
        tvTitle.visibility = View.VISIBLE
        tvTitle.setText("Forgot Password")
        imgback = findViewById(R.id.imgback)
        imgback.setOnClickListener {
            finish()
        }
        etEmaildId = findViewById(R.id.etEmaildId)
        etUserName = findViewById(R.id.etUserName)
        btnProcess = findViewById(R.id.btnProcess)
        btnProcess.setOnClickListener {
            validate()

        }
    }

    private fun validate() {
        if (TextUtils.isEmpty(etEmaildId.text.toString().trim())) {
            etEmaildId.error = "Please enter Email ID"
            etEmaildId.requestFocus()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(etEmaildId.text.toString().trim())
                .matches()
        ) {
            etEmaildId.error = "Please enter valid Email ID"
            etEmaildId.requestFocus()

        } else {
            Toast.makeText(this, "Do Next Task", Toast.LENGTH_SHORT).show()
        }

    }

    private fun dismissProgressDialog() {
        progressLayout.visibility = View.GONE
    }

    private fun showProgressDialog() {
        progressLayout.visibility = View.VISIBLE
    }
}