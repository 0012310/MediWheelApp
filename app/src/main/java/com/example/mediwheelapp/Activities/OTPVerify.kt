package com.example.mediwheelapp.Activities

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mediwheelapp.securitypin.SharedPreferenceUtils
import com.example.mediwheelapp.R


class OTPVerify : AppCompatActivity() {
    private lateinit var progressLayout: ConstraintLayout
    lateinit var etOne: EditText
    lateinit var etTwo: EditText
    lateinit var etThree: EditText
    lateinit var etFour: EditText
    lateinit var btnVerify: Button
    var requiredPIN = ""


    private lateinit var sharedPreferences: SharedPreferenceUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpverify)
        progressLayout = findViewById(R.id.progressLayout)
        sharedPreferences = SharedPreferenceUtils.getInstance(this)
        etOne = findViewById(R.id.etOne)
        etTwo = findViewById(R.id.etTwo)
        etThree = findViewById(R.id.etThree)
        etFour = findViewById(R.id.etFour)

        etOne.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                text: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
                if (etOne.text.length == 1) {
                    etTwo.requestFocus()
                    etOne.getBackground().setColorFilter(
                        getResources().getColor(R.color.otpbgfilled),
                        PorterDuff.Mode.MULTIPLY
                    )
                } else {
                    etOne.getBackground().setColorFilter(
                        getResources().getColor(R.color.white),
                        PorterDuff.Mode.MULTIPLY
                    )
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        etTwo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                text: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
                if (etTwo.text.length == 1) {
                    etThree.requestFocus()
                    etTwo.getBackground().setColorFilter(
                        getResources().getColor(R.color.otpbgfilled),
                        PorterDuff.Mode.MULTIPLY
                    )
                } else if (etTwo.text.length >= 0) {
                    etOne.requestFocus()
                    etTwo.getBackground().setColorFilter(
                        getResources().getColor(R.color.white),
                        PorterDuff.Mode.MULTIPLY
                    )
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        etThree.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                text: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
                if (etThree.text.length > 0) {
                    etFour.requestFocus()
                    etThree.getBackground().setColorFilter(
                        getResources().getColor(R.color.otpbgfilled),
                        PorterDuff.Mode.MULTIPLY
                    )
                } else {
                    etTwo.requestFocus()
                    etThree.getBackground().setColorFilter(
                        getResources().getColor(R.color.white),
                        PorterDuff.Mode.MULTIPLY
                    )
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        etFour.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                text: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(text: CharSequence, start: Int, before: Int, count: Int) {
                if (etFour.text.length == 1) {
                    etFour.getBackground().setColorFilter(
                        getResources().getColor(R.color.otpbgfilled),
                        PorterDuff.Mode.MULTIPLY
                    )
                } else {
                    etThree.requestFocus()
                    etFour.getBackground().setColorFilter(
                        getResources().getColor(R.color.white),
                        PorterDuff.Mode.MULTIPLY
                    )
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
        btnVerify = findViewById(R.id.btnVerify)
        btnVerify.setOnClickListener {
            requiredPIN =
                etOne.text.toString() + etTwo.text.toString() + etThree.text.toString() + etFour.text.toString()
            if (requiredPIN != null) {
                if (requiredPIN.length == 4) {
                    val intent = Intent(this, CreatePin::class.java)
                    startActivity(intent)
                    showProgressDialog()
                    finish()
                } else {
                    Toast.makeText(this, "Please enter valid otp first", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun dismissProgressDialog() {
        progressLayout.visibility = View.GONE
    }

    private fun showProgressDialog() {
        progressLayout.visibility = View.VISIBLE
    }




}