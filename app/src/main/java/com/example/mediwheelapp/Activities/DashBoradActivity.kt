package com.example.mediwheelapp.Activities

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.mediwheelapp.Activities.securitypin.SharedPreferenceUtils
import com.example.mediwheelapp.ActivityWithRecyclerView.ExecutiveHealthPackageActivity
import com.example.mediwheelapp.R
import com.google.android.material.navigation.NavigationView

class DashBoradActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var sharedPreferences: SharedPreferenceUtils
    lateinit var cardViewExecutiveHP: CardView
    lateinit var cardViewHealtPathology: CardView
    private lateinit var imgDrawer: ImageView
    private lateinit var imgLogout: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_borad)
        sharedPreferences = SharedPreferenceUtils.getInstance(this)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val headerView = navigationView.getHeaderView(0)

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            null,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        navigationView.setNavigationItemSelectedListener(this)
        imgDrawer = findViewById(R.id.imgDrawer)
        imgDrawer.setOnClickListener {
            val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
            if (!drawer.isDrawerOpen(GravityCompat.START)) drawer.openDrawer(GravityCompat.START) else drawer.closeDrawer(
                GravityCompat.END
            )
        }

        imgLogout = findViewById(R.id.imgLogout)
        imgLogout.setOnClickListener {
            logOut()
        }

        cardViewExecutiveHP = findViewById(R.id.cardViewExecutiveHP)
        cardViewHealtPathology = findViewById(R.id.cardViewHealtPathology)

        cardViewExecutiveHP.setOnClickListener {
            val intent = Intent(this, ExecutiveHealthPackageActivity::class.java)
            startActivity(intent)
        }
    }

    private fun logOut() {
        val alert = AlertDialog.Builder(this)
        alert.setMessage("Are you sure want to logout?")
        alert.setCancelable(false)
            .setPositiveButton("Logout") { _, _ ->
                sharedPreferences.clear()
                startActivity(Intent(this, CreateAndSignInActivity::class.java))
                finish()
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
            }.setNegativeButton("Cancel", null)

        val alert1 = alert.create()
        alert1.show()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}