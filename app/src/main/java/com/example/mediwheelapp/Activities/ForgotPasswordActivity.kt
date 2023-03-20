package com.example.mediwheelapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.mediwheelapp.R

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var imgback: ImageView
    lateinit var tvTitle: TextView
    lateinit var btncChangepass: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        tvTitle=findViewById(R.id.tvTitle)
        tvTitle.visibility= View.VISIBLE
        tvTitle.setText("Forgot Password")
        imgback = findViewById(R.id.imgback)
        imgback.setOnClickListener {
            finish()
        }
        btncChangepass=findViewById(R.id.btncChangepass)
        btncChangepass.setOnClickListener {
          /*  val intent = Intent(this,ChangePasswordActivity::class.java)
            startActivity(intent)*/
        }
    }
}