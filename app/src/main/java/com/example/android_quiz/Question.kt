package com.example.android_quiz

data class Question (
    val id: Int,
    val question: String,
    val image: Int? = null,
    val firstAnswer: String,
    val secondAnswer: String,
    val thirdAnswer: String,
    val fourthAnswer: String,
    val correctAnswer: Int
)