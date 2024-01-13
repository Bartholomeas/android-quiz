package com.example.android_quiz

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RulesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)

        val rules = intent.getStringExtra("rules")

        // Assume you have a TextView in your activity_rules layout with the id tv_rules
        val rulesTextView = findViewById<TextView>(R.id.tv_rules)
        rulesTextView.text = rules
    }
}
