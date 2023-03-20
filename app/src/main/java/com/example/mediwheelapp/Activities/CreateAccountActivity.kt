package com.example.mediwheelapp.Activities


import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mediwheelapp.R

class CreateAccountActivity : AppCompatActivity() {
    lateinit var imgback: ImageView
    lateinit var btnProceed: Button

    lateinit var radioNormalUser: RadioButton
    lateinit var radioCorpUser: RadioButton
    lateinit var llcorporate: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        imgback = findViewById(R.id.imgback)
        imgback.setOnClickListener {
            finish()
        }
        radioNormalUser = findViewById(R.id.radioNormalUser)
        radioCorpUser = findViewById(R.id.radioCorpUser)
        llcorporate = findViewById(R.id.llcorporate)


        radioNormalUser.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                radioNormalUser.isChecked = true
                radioCorpUser.isChecked = false
                llcorporate.visibility = View.GONE
                Toast.makeText(this, "Normal User", Toast.LENGTH_SHORT).show()
            }
        }

        radioCorpUser.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                radioNormalUser.isChecked = false
                radioCorpUser.isChecked = true
                llcorporate.visibility = View.VISIBLE
                Toast.makeText(this, "Corporate User", Toast.LENGTH_SHORT).show()
            }
        }

        btnProceed=findViewById(R.id.btnProceed)
        btnProceed.setOnClickListener {
            val intent = Intent(this,DashBoradActivity::class.java)
            startActivity(intent)
        }


    }

}