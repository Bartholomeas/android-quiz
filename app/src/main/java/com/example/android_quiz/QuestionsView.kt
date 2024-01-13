package com.example.android_quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionsView : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mAllQuestions: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions_view)


        val category = intent.getStringExtra(Questions.category)
        mAllQuestions = intent.getStringExtra(Questions.totalQuestions)
        val numQuestions = mAllQuestions?.toIntOrNull() ?: 1

//        mQuestionsList = Questions.getQuestions(numQuestions)
        mQuestionsList = when(category) {
            "Nouns" -> Questions.getNounsQuestions(numQuestions)
            "Body Parts" -> Questions.getBodyPartsQuestions(numQuestions)
            "Present Simple" -> Questions.getPresentSimpleQuestions(numQuestions)
            else -> ArrayList()
        }
        setQuestion()

         val tvFirstAnswer = findViewById<TextView>(R.id.tv_first_answer)
         val tvSecondAnswer = findViewById<TextView>(R.id.tv_second_answer)
         val tvThirdAnswer = findViewById<TextView>(R.id.tv_third_answer)
         val tvFourthAnswer = findViewById<TextView>(R.id.tv_fourth_answer)

        val submitButton = findViewById<Button>(R.id.btn_submit)

        tvFirstAnswer.setOnClickListener(this)
        tvSecondAnswer.setOnClickListener(this)
        tvThirdAnswer.setOnClickListener(this)
        tvFourthAnswer.setOnClickListener(this)
        submitButton.setOnClickListener(this)

    }

    private fun setQuestion() {
        val question = mQuestionsList!![mCurrentPosition - 1]

        defaultOptionsView()

        val submitButton = findViewById<Button>(R.id.btn_submit)

        if(mCurrentPosition == mQuestionsList!!.size){
            submitButton.text = "Następne pytanie"
        } else {
            submitButton.text = "Zakończ"

        }

        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val tvProgress = findViewById<TextView>(R.id.tv_progress)
        val tvQuestion = findViewById<TextView>(R.id.tv_question)
        val ivImage = findViewById<ImageView>(R.id.iv_image)

        progressBar.max = mQuestionsList!!.size
        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition" + "/" + progressBar.max
        tvQuestion.text = question.question
        question.image?.let { ivImage.setImageResource(it) }

        val tvFirstAnswer = findViewById<TextView>(R.id.tv_first_answer)
        val tvSecondAnswer = findViewById<TextView>(R.id.tv_second_answer)
        val tvThirdAnswer = findViewById<TextView>(R.id.tv_third_answer)
        val tvFourthAnswer = findViewById<TextView>(R.id.tv_fourth_answer)

        tvFirstAnswer.text = question.firstAnswer
        tvSecondAnswer.text = question.secondAnswer
        tvThirdAnswer.text = question.thirdAnswer
        tvFourthAnswer.text = question.fourthAnswer
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()

        val tvFirstAnswer = findViewById<TextView>(R.id.tv_first_answer)
        val tvSecondAnswer = findViewById<TextView>(R.id.tv_second_answer)
        val tvThirdAnswer = findViewById<TextView>(R.id.tv_third_answer)
        val tvFourthAnswer = findViewById<TextView>(R.id.tv_fourth_answer)

        options.add(0, tvFirstAnswer)
        options.add(1, tvSecondAnswer)
        options.add(2, tvThirdAnswer)
        options.add(3, tvFourthAnswer)

        for (option in options) {
            println(option)
//            option.setTextColor(Color.parseColor("#333"))
//            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_answer_bg)
        }
    }

    private fun selectedOptionView(tv:TextView, selectedOptionNum:Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

//        tv.setTextColor(Color.parseColor("#828282"))
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_answer_bg)
    }

    private fun setCorrectAnswer(answer:Int, drawableView:Int ) {
        val tvFirstAnswer = findViewById<TextView>(R.id.tv_first_answer)
        val tvSecondAnswer = findViewById<TextView>(R.id.tv_second_answer)
        val tvThirdAnswer = findViewById<TextView>(R.id.tv_third_answer)
        val tvFourthAnswer = findViewById<TextView>(R.id.tv_fourth_answer)

        when(answer){
            1 ->{
                tvFirstAnswer.background = ContextCompat.getDrawable(this, drawableView
                )
            }
            2 ->{
                tvSecondAnswer.background = ContextCompat.getDrawable(this, drawableView
                )
            }
            3 ->{
                tvThirdAnswer.background = ContextCompat.getDrawable(this, drawableView
                )
            }
            4 ->{
                tvFourthAnswer.background = ContextCompat.getDrawable(this, drawableView
                )
            }
        }
    }

    override fun onClick(p0: View?) {

        val tvFirstAnswer = findViewById<TextView>(R.id.tv_first_answer)
        val tvSecondAnswer = findViewById<TextView>(R.id.tv_second_answer)
        val tvThirdAnswer = findViewById<TextView>(R.id.tv_third_answer)
        val tvFourthAnswer = findViewById<TextView>(R.id.tv_fourth_answer)

        val submitButton = findViewById<Button>(R.id.btn_submit)

        when(p0?.id) {
            R.id.tv_first_answer -> {
                selectedOptionView(tvFirstAnswer, 1)
            }
            R.id.tv_second_answer -> {
                selectedOptionView(tvSecondAnswer, 2)
            }
            R.id.tv_third_answer -> {
                selectedOptionView(tvThirdAnswer,3)
            }
            R.id.tv_fourth_answer -> {
                selectedOptionView(tvFourthAnswer,4)
            }

            R.id.btn_submit -> {
            if(mSelectedOptionPosition == 0) {
                mCurrentPosition ++

                when {
                    mCurrentPosition <= mQuestionsList!!.size ->{
                        setQuestion()
                    } else ->{
                    val intent = Intent(this, FinalViewActivity::class.java)
                    intent.putExtra(Questions.totalQuestions, mAllQuestions)
                    intent.putExtra(Questions.correctAnswers, mCorrectAnswers)
                    intent.putExtra(Questions.totalQuestions, mQuestionsList!!.size)
                    startActivity(intent)
                    }
                }
            } else {
                val question = mQuestionsList?.get(mCurrentPosition-1)
                if(question!!.correctAnswer != mSelectedOptionPosition) {
                    setCorrectAnswer(mSelectedOptionPosition, R.drawable.wrong_answer_bg)
                } else {
                    mCorrectAnswers++
                }
                setCorrectAnswer(question.correctAnswer, R.drawable.correct_answer_bg)

                if(mCurrentPosition == mQuestionsList!!.size){
                    submitButton.text = "Zakończ quiz"
                } else {
                    submitButton.text = "Przejdź do kolejnego pytania"
                }
                mSelectedOptionPosition = 0
            }

            }
        }
    }




}