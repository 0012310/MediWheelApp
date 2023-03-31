package com.example.mediwheelapp.Activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mediwheelapp.R

class CorporateLoginUserNamePass : AppCompatActivity() {
    private lateinit var progressLayout: ConstraintLayout
    lateinit var imgback: ImageView
    lateinit var tvforgotpass: TextView
    lateinit var tv: TextView

    lateinit var etEmailId: EditText
    lateinit var btnProcess: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corporate_login_user_name_pass)
        progressLayout = findViewById(R.id.progressLayout)
        imgback = findViewById(R.id.imgback)
        imgback.setOnClickListener {
            finish()
        }
        tvforgotpass = findViewById(R.id.tvforgotpass)
        tvforgotpass.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
        tv = findViewById(R.id.tv)
        tv.text =
            Html.fromHtml("<font color=${Color.BLACK}>Having trouble in sign in? </font>" + "<font color=${"#1878F1"}> Get help here</font>")

        etEmailId = findViewById(R.id.etEmailId)
        btnProcess = findViewById(R.id.btnProcess)

        btnProcess.setOnClickListener {
            validate()
        }


    }

    private fun validate() {
        if (TextUtils.isEmpty(etEmailId.text.toString().trim())) {
            etEmailId.error = "Please enter Email ID"
            etEmailId.requestFocus()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(etEmailId.text.toString().trim()).matches()) {
            etEmailId.error = "Please enter valid Email ID"
            etEmailId.requestFocus()
        } else {
            Toast.makeText(this, "Do what Next Task", Toast.LENGTH_SHORT).show()
        }
    }

    private fun dismissProgressDialog() {
        progressLayout.visibility = View.GONE
    }

    private fun showProgressDialog() {
        progressLayout.visibility = View.VISIBLE
    }


}