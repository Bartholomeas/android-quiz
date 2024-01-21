package com.example.android_quiz

import VocabularyAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class VocabularyFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var vocabularyAdapter: VocabularyAdapter
    private val vocabularyItemsList = mutableListOf<VocabularyItem>()

    private val database: FirebaseDatabase by lazy {
        FirebaseDatabase.getInstance(FirebaseApp.initializeApp(requireContext())!!)
    }
    private val firebaseRef: DatabaseReference by lazy { database.getReference("vocabulary_items") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vocabulary, container, false)

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        vocabularyAdapter = VocabularyAdapter(vocabularyItemsList)
        recyclerView.adapter = vocabularyAdapter

        setupFirebaseListener()

        return view
    }

    private fun setupFirebaseListener() {
        firebaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                vocabularyItemsList.clear()

                for (itemSnapshot in snapshot.children) {
                    val word = itemSnapshot.child("word").getValue(String::class.java)
                    val translation = itemSnapshot.child("translation").getValue(String::class.java)

                    if (word != null && translation != null) {
                        val vocabularyItem = VocabularyItem(word, translation)
                        vocabularyItemsList.add(vocabularyItem)
                    }
                }

                vocabularyAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
