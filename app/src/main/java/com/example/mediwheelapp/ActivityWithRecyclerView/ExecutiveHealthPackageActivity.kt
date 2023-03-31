package com.example.mediwheelapp.ActivityWithRecyclerView

import android.media.Image
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.mediwheelapp.R

class ExecutiveHealthPackageActivity : AppCompatActivity() {
    lateinit var imgback: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_executive_health_package)

        imgback = findViewById(R.id.imgback)
        imgback.setOnClickListener {
            finish()
        }



    }
}