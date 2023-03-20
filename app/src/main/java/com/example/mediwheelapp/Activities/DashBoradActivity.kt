package com.example.mediwheelapp.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.mediwheelapp.ActivityWithRecyclerView.ExecutiveHealthPackageActivity
import com.example.mediwheelapp.R

class DashBoradActivity : AppCompatActivity() {
    lateinit var cardViewExecutiveHP: CardView
    lateinit var cardViewHealtPathology: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_borad)
        cardViewExecutiveHP = findViewById(R.id.cardViewExecutiveHP)
        cardViewHealtPathology = findViewById(R.id.cardViewHealtPathology)

        cardViewExecutiveHP.setOnClickListener {
            val intent = Intent(this, ExecutiveHealthPackageActivity::class.java)
            startActivity(intent)
        }
    }
}