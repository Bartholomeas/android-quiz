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
import com.google.firebase.database.database


class VocabularyFragment : Fragment() {


    private val database = Firebase.database
    private val firebaseRef = database.getReference("vocabulary_items")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_vocabulary, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = VocabularyAdapter(getVocabularyItems())

        val addToDbBtn = view.findViewById<Button>(R.id.add_to_db)


        addToDbBtn.setOnClickListener {
            val vocabularyItems = getVocabularyItems()

            // Clear previous data
            firebaseRef.removeValue()

            // Push each item to Firebase
            for (item in vocabularyItems) {
                firebaseRef.push().setValue(item)
            }

            Toast.makeText(requireContext(), "Sukces, dodano", Toast.LENGTH_SHORT).show()
        }


        return view
    }


    private fun getVocabularyItems(): List<VocabularyItem> {
            return listOf(
                VocabularyItem("apple", "jabłko"),
                VocabularyItem("banana", "banan"),
                VocabularyItem("cat", "kot"),
                VocabularyItem("dog", "pies"),
                VocabularyItem("house", "dom"),
                VocabularyItem("car", "samochód"),
                VocabularyItem("book", "książka"),
                VocabularyItem("desk", "biurko"),
                VocabularyItem("chair", "krzesło"),
                VocabularyItem("door", "drzwi"),
                VocabularyItem("window", "okno"),
                VocabularyItem("computer", "komputer"),
                VocabularyItem("phone", "telefon"),
                VocabularyItem("bottle", "butelka"),
                VocabularyItem("tree", "drzewo"),
                VocabularyItem("flower", "kwiat"),
                VocabularyItem("sun", "słońce"),
                VocabularyItem("moon", "księżyc"),
                VocabularyItem("star", "gwiazda"),
                VocabularyItem("water", "woda"),
                VocabularyItem("fire", "ogień"),
                VocabularyItem("earth", "ziemia"),
                VocabularyItem("air", "powietrze"),
                VocabularyItem("animal", "zwierzę"),
                VocabularyItem("bird", "ptak"),
                VocabularyItem("fish", "ryba"),
                VocabularyItem("mountain", "góra"),
                VocabularyItem("river", "rzeka"),
                VocabularyItem("ocean", "ocean"),
                VocabularyItem("forest", "las"),
                VocabularyItem("beach", "plaża"),
                VocabularyItem("city", "miasto"),
                VocabularyItem("country", "kraj"),
                VocabularyItem("language", "język"),
                VocabularyItem("love", "miłość"),
                VocabularyItem("friendship", "przyjaźń"),
                VocabularyItem("peace", "pokój"),
                VocabularyItem("war", "wojna"),
                VocabularyItem("freedom", "wolność"),
                VocabularyItem("justice", "sprawiedliwość"),
                VocabularyItem("knowledge", "wiedza"),
                VocabularyItem("wisdom", "mądrość"),
                VocabularyItem("kindness", "dobroć"),
                VocabularyItem("happiness", "szczęście"),
                VocabularyItem("dream", "sen"),
                VocabularyItem("reality", "rzeczywistość"),
                VocabularyItem("truth", "prawda"),
                VocabularyItem("lie", "kłamstwo"),
                VocabularyItem("hope", "nadzieja"),
                VocabularyItem("despair", "rozpacz"),
                VocabularyItem("life", "życie"),
                VocabularyItem("death", "śmierć"),
                VocabularyItem("youth", "młodość"),
                VocabularyItem("old age", "starość"),
                VocabularyItem("man", "mężczyzna"),
                VocabularyItem("woman", "kobieta"),
                VocabularyItem("child", "dziecko"),
                VocabularyItem("family", "rodzina"),
                VocabularyItem("work", "praca"),
                VocabularyItem("rest", "odpoczynek"),
                VocabularyItem("food", "jedzenie"),
                VocabularyItem("drink", "picie"),
                VocabularyItem("hunger", "głód"),
                VocabularyItem("thirst", "pragnienie"),
                VocabularyItem("joy", "radość"),
                VocabularyItem("sorrow", "smutek"),
                VocabularyItem("light", "światło"),
                VocabularyItem("darkness", "ciemność"),
                VocabularyItem("morning", "rano"),
                VocabularyItem("evening", "wieczór"),
                VocabularyItem("night", "noc"),
                VocabularyItem("day", "dzień"),
                VocabularyItem("week", "tydzień"),
                VocabularyItem("month", "miesiąc"),
                VocabularyItem("year", "rok"),
                VocabularyItem("time", "czas"),
                VocabularyItem("past", "przeszłość"),
                VocabularyItem("present", "teraźniejszość"),
                VocabularyItem("future", "przyszłość"),
                VocabularyItem("north", "północ"),
                VocabularyItem("south", "południe"),
                VocabularyItem("east", "wschód"),
                VocabularyItem("west", "zachód"),
                VocabularyItem("spring", "wiosna"),
                VocabularyItem("summer", "lato"),
                VocabularyItem("autumn", "jesień"),
                VocabularyItem("winter", "zima"),
                VocabularyItem("rain", "deszcz"),
                VocabularyItem("snow", "śnieg"),
                VocabularyItem("wind", "wiatr"),
                VocabularyItem("storm", "burza"),
                VocabularyItem("cloud", "chmura"),
                VocabularyItem("sky", "niebo"),
                VocabularyItem("earth", "ziemia"),
                VocabularyItem("nature", "natura"),
                VocabularyItem("music", "muzyka"),
                VocabularyItem("art", "sztuka"),
                VocabularyItem("literature", "literatura"),
                VocabularyItem("science", "nauka"),
                VocabularyItem("history", "historia"),
                VocabularyItem("religion", "religia"),
                VocabularyItem("philosophy", "filozofia"),
                VocabularyItem("politics", "polityka"),
                VocabularyItem("economics", "ekonomia"),
                VocabularyItem("education", "edukacja"),
                VocabularyItem("health", "zdrowie"),
                VocabularyItem("travel", "podróż"),
                VocabularyItem("adventure", "przygoda"),
                VocabularyItem("fun", "zabawa"),
                VocabularyItem("game", "gra"),
                VocabularyItem("sport", "sport"),
                VocabularyItem("dancing", "taniec"),
                VocabularyItem("cinema", "kino"),
                VocabularyItem("theatre", "teatr"),
                VocabularyItem("photography", "fotografia"),
                VocabularyItem("painting", "malarstwo"),
                VocabularyItem("poetry", "poezja"),
                VocabularyItem("novel", "powieść"),
                VocabularyItem("story", "opowieść"),
                VocabularyItem("myth", "mit"),
                VocabularyItem("legend", "legenda"),
                VocabularyItem("tradition", "tradycja"),
                VocabularyItem("culture", "kultura"),
                VocabularyItem("society", "społeczeństwo"),
                VocabularyItem("humanity", "ludzkość"),
                VocabularyItem("universe", "wszechświat")
            )

    }

}