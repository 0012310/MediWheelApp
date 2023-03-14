package com.example.mediwheelapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.mediwheelapp.R

class SignupActivity : AppCompatActivity() {
    lateinit var imgback : ImageView
    lateinit var forgotTv : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        imgback = findViewById(R.id.imgback)
        imgback.setOnClickListener {
            finish()
        }
        forgotTv=findViewById(R.id.forgotTv)
        forgotTv.setOnClickListener {
            val intent = Intent(this,ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}