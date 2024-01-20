package com.example.android_quiz

import VocabularyAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class VocabulariesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocabulary)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, VocabularyFragment())
            .commit()
    }


}
