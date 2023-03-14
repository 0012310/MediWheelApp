package com.example.mediwheelapp.Activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import com.example.mediwheelapp.R

class CorporateLoginUserNamePass : AppCompatActivity() {
    lateinit var imgback: ImageView
    lateinit var tvforgotpass: TextView
    lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corporate_login_user_name_pass)
        imgback = findViewById(R.id.imgback)
        imgback.setOnClickListener {
            finish()
        }
        tvforgotpass=findViewById(R.id.tvforgotpass)
        tvforgotpass.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
        tv = findViewById(R.id.tv)
        tv.text =
            Html.fromHtml("<font color=${Color.BLACK}>Having trouble in sign in? </font>" + "<font color=${"#1878F1"}> Get help here</font>")
    }
}