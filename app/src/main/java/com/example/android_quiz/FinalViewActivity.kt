package com.example.android_quiz

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.CorrectionInfo
import android.widget.Button
import android.widget.TextView

class FinalViewActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_view)

        val tvAllQuestions = findViewById<TextView>(R.id.tv_allQuestions)
        val tvCorrectAnswers = findViewById<TextView>(R.id.tv_score)
        val finishButton = findViewById<Button>(R.id.btn_finish)

        sharedPreferences = getSharedPreferences("quiz_scores", Context.MODE_PRIVATE)

        val totalQuestions = intent.getIntExtra(Questions.totalQuestions,0)
        val correctAnswers = intent.getIntExtra(Questions.correctAnswers,0)

        updateScoreInSharedPreferences(correctAnswers,totalQuestions)

        tvAllQuestions.text = totalQuestions.toString()
        tvCorrectAnswers.text = "Zdobyłeś $correctAnswers z $totalQuestions punktów"

        finishButton.setOnClickListener{startActivity(Intent(this, MainActivity::class.java))}


    }

    private fun updateScoreInSharedPreferences(correctAnswers: Int, totalQuestion: Int) {
        val editor = sharedPreferences.edit()

        val oldCorrectAnswers = sharedPreferences.getInt("correct_answers", 0)
        val oldTotalAnswers = sharedPreferences.getInt("total_answers", 0)

        editor.putInt("correct_answers", oldCorrectAnswers + correctAnswers)
        editor.putInt("total_answers", oldTotalAnswers + totalQuestion)
        editor.apply()
    }
}