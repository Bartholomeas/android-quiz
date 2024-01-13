package com.example.android_quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}
