package com.example.mediwheelapp.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mediwheelapp.securitypin.EnterSecurityPinActivity
import com.example.mediwheelapp.securitypin.SharedPreferenceUtils
import com.example.mediwheelapp.R

class SplashActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferenceUtils

    private val ENTERED_SECURE_PIN = 2000
    private var enteredSecurePin = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        sharedPreferences = SharedPreferenceUtils.getInstance(this)
        waitAndGo()

    }


    private fun waitAndGo() {
        Handler().postDelayed(
            {
                if (sharedPreferences.getBoolanValue("isUserLogin", false)) {
                    if (enteredSecurePin) {
                        val intent = Intent(this, DashBoradActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        val intent = Intent(this, EnterSecurityPinActivity::class.java)
                        startActivityForResult(intent, ENTERED_SECURE_PIN)
                    }


                } else {
                    showToast("Welcome to the MediWheel")
                    val intent = Intent(this, CreateAndSignInActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }, 2000
        )
    }


    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ENTERED_SECURE_PIN) {
            if (data != null) {
                enteredSecurePin = data.getBooleanExtra("enter_pin", false)
            } else {
                finish()
            }
            if (enteredSecurePin) {
                waitAndGo()
            }

        }
    }



}