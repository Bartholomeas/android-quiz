package com.example.android_quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout:DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//--------
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if(savedInstanceState == null)  {
            replaceFragment(HomeFragment())
            navigationView.setCheckedItem(R.id.nav_home)
        }
//--------


        val beginButton = findViewById<Button>(R.id.btn_begin)
        val learnButton = findViewById<Button>(R.id.btn_learn_grammar)
        val learnWordsButton = findViewById<Button>(R.id.btn_learn_words)
        val questionsNum = findViewById<AppCompatEditText>(R.id.questions_num)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        beginButton.setOnClickListener{
            if(questionsNum.text.toString().isEmpty()){
                Toast.makeText(this, "Wprowadź liczbę pytań", Toast.LENGTH_SHORT).show()
            } else {
                val spinner = findViewById<Spinner>(R.id.categories_spinner)
                val numQuestionsEditText = findViewById<EditText>(R.id.questions_num)
                val numQuestions = numQuestionsEditText.text.toString().toIntOrNull() ?: 1
                val selectedCategory = spinner.selectedItem.toString()

                val intent = Intent(this,QuestionsView::class.java )
                intent.putExtra(Questions.totalQuestions, questionsNum.text.toString())
                intent.putExtra(Questions.category,selectedCategory)
                startActivity(intent)
                finish()
            }
        }

        learnButton.setOnClickListener{
            val intent = Intent(this, GrammarTimeActivity::class.java)
            startActivity(intent)
        }
        learnWordsButton.setOnClickListener{
            val intent = Intent(this, VocabulariesActivity::class.java)
            startActivity(intent)
        }
    }
private fun replaceFragment(fragment: Fragment) {
    val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.fragment_container, fragment)
    transaction.commit()
}

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d("XD","xd")
//        when(item.itemId) {
//            R.id.nav_home -> replaceFragment(HomeFragment())
//            R.id.nav_settings -> replaceFragment(SettingsFragment())
//            R.id.nav_about -> replaceFragment(AboutFragment())
//        }
//        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
