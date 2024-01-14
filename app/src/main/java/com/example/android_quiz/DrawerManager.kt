package com.example.android_quiz

import android.util.Log
import android.view.MenuItem
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class DrawerManager(private val activity: AppCompatActivity) {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var btnMenu: ImageButton
    init {
        Log.d("DrawerManager", "DrawerManager created")
        initializeDrawer()
    }
    fun initializeDrawer() {
        Log.d("DrawerManager", "Inicjalizacja szuflady")

        drawerLayout = activity.findViewById(R.id.fragment_container)
        val toolbar = activity.findViewById<Toolbar>(R.id.toolBar)

        val toggle = ActionBarDrawerToggle(activity,drawerLayout,toolbar,R.string.menu_drawer_open, R.string.menu_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        btnMenu = toolbar.findViewById(R.id.toggleDrawer)
        btnMenu.setOnClickListener {
            openDrawer()
        }
    }

    fun openDrawer () {
        Log.d("DrawerManager","Otwieram szuflade")
        drawerLayout.openDrawer(GravityCompat.START)
    }

    fun closeDrawer () {
        Log.d("DrawerManager","Zamykam szuflade")
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    fun handleNavigationItemSelected(item:MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> {
                closeDrawer()
                return true
            }
            R.id.nav_help_cards -> {
                closeDrawer()

                return true
            }
            else -> return false
        }
    }

}