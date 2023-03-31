package com.example.mediwheelapp.Activities

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mediwheelapp.R

class TermAndCondition : AppCompatActivity() {
    private lateinit var progressLayout: ConstraintLayout
    lateinit var imgback: ImageView
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_term_and_condition)
        progressLayout = findViewById(R.id.progressLayout)
        imgback = findViewById(R.id.imgback)
        imgback.setOnClickListener {
            finish()
        }

        webView = findViewById(R.id.webView)
        webView.loadUrl("https://www.mediwheel.in/")
        showProgressDialog()

        Handler().postDelayed(
            {
                dismissProgressDialog()
            }, 2500
        )


        /* webView.settings.javaScriptEnabled = true
         webView.settings.setSupportZoom(true)
         webView.settings.builtInZoomControls = true
         webView.settings.displayZoomControls = false
        // webView.loadUrl("https://setu.pmjay.gov.in/setu/NHA-data-privacy-policy-v2.0")
         webView.loadUrl("https://www.computerhope.com/htmcolor.htm")
         webView.webViewClient = MyWebViewClient()
 */
    }


    internal class MyWebViewClient : WebViewClient() {
        override fun onPageStarted(view: WebView, url: String, favicon: Bitmap) {
            super.onPageStarted(view, url, favicon)
        }


    }


    private fun dismissProgressDialog() {
        progressLayout.visibility = View.GONE
    }

    private fun showProgressDialog() {
        progressLayout.visibility = View.VISIBLE
    }
}


