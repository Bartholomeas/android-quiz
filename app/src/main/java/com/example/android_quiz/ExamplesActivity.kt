package com.example.android_quiz

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExamplesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_examples)

        val examples = intent.getStringExtra("examples")

        val examplesTextView = findViewById<TextView>(R.id.tv_examples)
        examplesTextView.text = examples
    }
}
