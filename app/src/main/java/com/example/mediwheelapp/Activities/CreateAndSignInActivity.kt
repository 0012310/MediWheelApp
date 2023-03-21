package com.example.mediwheelapp.Activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.mediwheelapp.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import org.nha.pmjay.activity.adapter.ImageViewPagerAdapter


class CreateAndSignInActivity : AppCompatActivity() {
    var mViewPager: ViewPager? = null
    lateinit var tvCorporate: TextView

    lateinit var btnProceed: Button

    lateinit var tv: TextView
    lateinit var tv2: TextView

    private var page = 0
    private val delay = 3000
    private var runnable: Runnable? = null
    private val handler: Handler? = null

    var images = intArrayOf(
        R.drawable.drimage,
        R.drawable.roundlogo,
        R.drawable.drimage
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_and_sign_in)
        tvCorporate = findViewById(R.id.tvCorporate)
        btnProceed = findViewById(R.id.btnProceed)

        mViewPager = findViewById<View>(R.id.viewPager) as ViewPager
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)


        val mViewPagerAdapter = ImageViewPagerAdapter(this, images)
        mViewPager!!.adapter = mViewPagerAdapter
        dotsIndicator.setViewPager(mViewPager!!)

        tvCorporate.setOnClickListener {

            val intent = Intent(this, CorporateActivity::class.java)
            startActivity(intent)
        }

        tv = findViewById(R.id.tv)
        tv2 = findViewById(R.id.tv2)
        tv.text =
            Html.fromHtml("<font color=${Color.BLACK}>Having trouble in sign in? </font>" + "<font color=${"#1878F1"}> Get help here</font>")
        tv2.text =
            Html.fromHtml("<font color=${"#1878F1"}>Term and conditions? </font>" + "and" + "<font color=${"#1878F1"}> Privacy policy</font>")

        btnProceed.setOnClickListener {
            callScreen()
        }

    }

    private fun callScreen() {
        val intent = Intent(this, OTPVerify::class.java)
        startActivity(intent)
    }


}

