package com.example.android_quiz

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout:DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//--------
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            navigationView.setCheckedItem(R.id.nav_home)
        }
//--------

        updateResultsInNavigationView()
    }
private fun replaceFragment(fragment: Fragment) {
    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.fragment_container, fragment)
    transaction.commit()
}

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_home -> replaceFragment(HomeFragment())
            R.id.nav_settings -> replaceFragment(GrammarTimeFragment())
            R.id.nav_about -> replaceFragment(VocabularyFragment())
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun updateResultsInNavigationView() {
        val sharedPreferences = getSharedPreferences("quiz_scores", Context.MODE_PRIVATE)
        val totalAnswers = sharedPreferences.getInt("total_answers", 0)
        val correctAnswers = sharedPreferences.getInt("correct_answers", 0)

        val headerView = navigationView.getHeaderView(0)
        val correctAnswersTextView = headerView.findViewById<TextView>(R.id.correct_answers)
        val allAnswersTextView = headerView.findViewById<TextView>(R.id.all_answers)

        correctAnswersTextView.text = "Poprawnych: $correctAnswers"
        allAnswersTextView.text = "Z wszystkich: $totalAnswers"

    }
    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
