package com.example.mediwheelapp.Activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.Html
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import com.example.mediwheelapp.R
import com.example.mediwheelapp.securitypin.SharedPreferenceUtils
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import org.nha.pmjay.activity.adapter.ImageViewPagerAdapter
import java.util.regex.Pattern


class CreateAndSignInActivity : AppCompatActivity() {
    private lateinit var progressLayout: ConstraintLayout
    private lateinit var sharedPreferences: SharedPreferenceUtils
    var mViewPager: ViewPager? = null
    lateinit var tvCorporate: TextView
    lateinit var etMobNo: EditText
    lateinit var etName: EditText
    lateinit var etEmailId: EditText

    lateinit var btnProceed: Button

    lateinit var tv: TextView
    lateinit var tvTermsandCon: TextView

    private var page = 0
    private val delay = 3000
    private var runnable: Runnable? = null
    private val handler: Handler? = null

    private val MOBILE_REGEX = "^[6789]\\d{9}$"

    var images = intArrayOf(
        R.drawable.drimage, R.drawable.roundlogo, R.drawable.drimage
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_and_sign_in)
        progressLayout = findViewById(R.id.progressLayout)
        sharedPreferences = SharedPreferenceUtils.getInstance(this)
        tvCorporate = findViewById(R.id.tvCorporate)
        etMobNo = findViewById(R.id.etMobNo)
        etName = findViewById(R.id.etName)
        etEmailId = findViewById(R.id.etEmailId)
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
        tv.text =
            Html.fromHtml("<font color=${Color.BLACK}>Having trouble in sign in? </font>" + "<font color=${"#1878F1"}> Get help here</font>")

        tvTermsandCon = findViewById(R.id.tvTermsandCon)
        tvTermsandCon.text =
            Html.fromHtml("<font color=${"#1878F1"}>Term and conditions? </font>" + "and" + "<font color=${"#1878F1"}> Privacy policy</font>")
        tvTermsandCon.setOnClickListener {
            val intent = Intent(this, TermAndCondition::class.java)
            startActivity(intent)

        }


        btnProceed.setOnClickListener {
            ValidateInput()
        }

    }

    private fun ValidateInput() {
        if (TextUtils.isEmpty(etMobNo.text.toString().trim())) {
            etMobNo.error = "Please enter Mobile Number"
            etMobNo.requestFocus()
        } else if (!Pattern.compile(MOBILE_REGEX).matcher(etMobNo.text.toString().trim())
                .matches()
        ) {
            etMobNo.error = "Please enter valid Mobile Number"
            etMobNo.requestFocus()
        } else if (TextUtils.isEmpty(etName.text.toString().trim())) {
            etName.error = "Please enter Name"
            etName.requestFocus()
        } else if (TextUtils.isEmpty(etEmailId.text.toString().trim())) {
            etEmailId.error = "Please enter Email ID"
            etEmailId.requestFocus()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(etEmailId.text.toString().trim()).matches()) {
            etEmailId.error = "Please enter valid Email ID"
            etEmailId.requestFocus()
        } else {
            sharedPreferences.setStringValue("Mobile", etMobNo.text.toString())
            sharedPreferences.setStringValue("Name", etName.text.toString())
            sharedPreferences.setStringValue("Email", etEmailId.text.toString())
            callScreen()
            showProgressDialog()

        }
    }

    private fun callScreen() {
        val intent = Intent(this, OTPVerify::class.java)
        startActivity(intent)
        dismissProgressDialog()
    }

    private fun dismissProgressDialog() {
        progressLayout.visibility = View.GONE
    }

    private fun showProgressDialog() {
        progressLayout.visibility = View.VISIBLE
    }

    override fun onRestart() {
        super.onRestart()
        dismissProgressDialog()
    }


}

