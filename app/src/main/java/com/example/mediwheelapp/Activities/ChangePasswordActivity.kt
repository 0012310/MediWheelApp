package com.example.mediwheelapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.mediwheelapp.R

class ChangePasswordActivity : AppCompatActivity() {
    lateinit var imgback: ImageView
    lateinit var tvTitle: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_paswword)
        tvTitle=findViewById(R.id.tvTitle)
        tvTitle.visibility= View.VISIBLE
        tvTitle.setText("Change Password")
        imgback = findViewById(R.id.imgback)
        imgback.setOnClickListener {
            finish()
        }
    }
}