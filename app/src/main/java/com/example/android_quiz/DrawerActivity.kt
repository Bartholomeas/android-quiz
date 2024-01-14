package com.example.android_quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.ImageButton
import com.google.android.material.navigation.NavigationView

class DrawerActivity : AppCompatActivity() {
private lateinit var drawerManager: DrawerManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("DrawerActivity", "onCreate DrawerACTIVITY")

        drawerManager = DrawerManager(this)
        drawerManager.initializeDrawer()

        val toggleDrawer = findViewById<ImageButton>(R.id.toggleDrawer)
        toggleDrawer.setOnClickListener{
            drawerManager.openDrawer()
        }

        val container = findViewById<FrameLayout>(R.id.fragment_container)
        val contentView = layoutInflater.inflate(R.layout.activity_main,container, false)
        container.addView(contentView)

        val navigationView =  findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { item ->
            drawerManager.handleNavigationItemSelected(item)
        true
        }


    }


    fun onNavigationItemSelected(item:MenuItem) :Boolean{
        return false;
    }

    fun allocateActivityTitle(titleString:String)  {
//        supportActionBar?.setTitle(titleString)
        supportActionBar?.title = titleString
    }
}