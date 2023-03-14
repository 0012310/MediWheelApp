package com.example.mediwheelapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.example.mediwheelapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        waitAndGo()
    }

    private fun waitAndGo() {
        Handler().postDelayed(
            {
                showToast("Welcome to the MediWheel")
                val intent = Intent(this, CreateAndSignInActivity::class.java)
                startActivity(intent)
                finish()
            }, 2000
        )
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}