package com.example.android_quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.android_quiz.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {


    private lateinit var drawerLayout: DrawerLayout
    private lateinit var firebaseRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

firebaseRef = FirebaseDatabase.getInstance().getReference("test")

        setContentView(R.layout.activity_main)


//        val toolbar = findViewById<Toolbar>(R.id.toolBar)
//        setSupportActionBar(toolbar)
//        val navigationView = findViewById<NavigationView>(R.id.nav_view)
//        navigationView.setNavigationItemSelectedListener(this)
//
//
//        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.menu_drawer_open, R.string.menu_drawer_close)
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, HomeFragment()).commit()
//            navigationView.setCheckedItem(R.id.nav_home)
//        }

//        val navController = findNavController(R.id.fragmentContainer)
//        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.addFragment))
//        setupActionBarWithNavController(navController, appBarConfiguration)

//        Old
        val beginButton = findViewById<Button>(R.id.btn_begin)
        val learnButton = findViewById<Button>(R.id.btn_learn_grammar)
        val learnWordsButton = findViewById<Button>(R.id.btn_learn_words)
        val questionsNum = findViewById<AppCompatEditText>(R.id.questions_num)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val addToDB = findViewById<Button>(R.id.btn_add_record)

//        val navController = findNavController(R.id.fragmentContainerView)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.addFragment))
//        setupActionBarWithNavController(navController,appBarConfiguration)


        addToDB.setOnClickListener {
            firebaseRef.setValue("test value")
                .addOnCompleteListener{
                    Toast.makeText(this, "Dane dodane", Toast.LENGTH_SHORT).show()
                }
        }

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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            R.id.nav_help_cards -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, LearnFragment()).commit()
            R.id.nav_scoreboard -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AddFragment()).commit()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        super.onBackPressed()
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}
