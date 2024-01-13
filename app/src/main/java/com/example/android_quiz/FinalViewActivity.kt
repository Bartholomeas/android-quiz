package com.example.android_quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FinalViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_view)

        val tvAllQuestions = findViewById<TextView>(R.id.tv_allQuestions)
        val tvCorrectAnswers = findViewById<TextView>(R.id.tv_score)

        val finishButton = findViewById<Button>(R.id.btn_finish)


        val totalQuestions = intent.getIntExtra(Questions.totalQuestions,0)
        val correctAnswers = intent.getIntExtra(Questions.correctAnswers,0)

        tvAllQuestions.text = totalQuestions.toString()
        tvCorrectAnswers.text = "Zdobyłeś $correctAnswers z $totalQuestions punktów"

        finishButton.setOnClickListener{startActivity(Intent(this, MainActivity::class.java))}


    }
}