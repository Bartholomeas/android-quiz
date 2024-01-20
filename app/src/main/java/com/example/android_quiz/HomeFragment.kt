package com.example.android_quiz

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val beginButton = view.findViewById<Button>(R.id.btn_begin)
        val questionsNum = view.findViewById<AppCompatEditText>(R.id.questions_num)

        beginButton.setOnClickListener {
            if (questionsNum.text.toString().isEmpty()) {
                Toast.makeText(requireContext(), "Wprowadź liczbę pytań", Toast.LENGTH_SHORT).show()
            } else {
                val spinner = view.findViewById<Spinner>(R.id.categories_spinner)
                val numQuestionsEditText = view.findViewById<EditText>(R.id.questions_num)
                val numQuestions = numQuestionsEditText.text.toString().toIntOrNull() ?: 1
                val selectedCategory = spinner.selectedItem.toString()

                val intent = Intent(requireContext(), QuestionsView::class.java)
                intent.putExtra(Questions.totalQuestions, questionsNum.text.toString())
                intent.putExtra(Questions.category, selectedCategory)
                startActivity(intent)
                requireActivity().finish()
            }
        }



        return view
    }
}
