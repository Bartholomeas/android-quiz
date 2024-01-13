package com.example.android_quiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class GrammarTimeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grammar_times)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = GrammarTimesAdapter(getGrammarTimes())
    }

    private fun getGrammarTimes(): List<GrammarTime> {
        return listOf(
            GrammarTime(
                "Present Simple",
                "Present Simple jest używany do wyrażania stałych sytuacji, nawyków i ogólnych prawd. Czas ten jest też używany do mówienia o czynnościach rutynowych i stałym stanie rzeczy.\n\n" +
                        "Często używamy go razem ze słowami, które wskazują na częstotliwość, takie jak 'always', 'usually', 'sometimes', 'never', 'every day', 'once a week' itp.",
                "W przypadku czasowników regularnych, do formy podstawowej czasownika dodajemy 's' dla trzeciej osoby liczby pojedynczej (he, she, it). Na przykład: He plays football every Sunday.\n\n" +
                        "Jeżeli czasownik kończy się na 'ss', 'sh', 'ch', 'x' lub 'o', dodajemy 'es'. Na przykład: She goes to school.\n\n" +
                        "Jeżeli czasownik kończy się na 'y' poprzedzone spółgłoską, zmieniamy 'y' na 'i' i dodajemy 'es'. Na przykład: He studies English.",
                "1. I play football every weekend.\n" +
                        "2. She works in a bank.\n" +
                        "3. They live in London.\n" +
                        "4. He doesn't like spinach.\n" +
                        "5. Do you speak English?\n" +
                        "6. Sarah goes to school by bus.\n" +
                        "7. I study English every day.\n" +
                        "8. My parents live in New York.\n" +
                        "9. We usually eat breakfast at 7am.\n" +
                        "10. She doesn't smoke."
            ),
            GrammarTime(
                "Past Simple",
                "Past Simple jest używany do opisania zdarzeń, które miały miejsce w przeszłości i już się zakończyły. Czas ten jest też używany do mówienia o czynnościach, które miały miejsce raz, nigdy lub kilka razy w przeszłości.\n\n" +
                        "Często używamy go razem ze słowami, które wskazują na czas w przeszłości, takie jak 'yesterday', 'last week', 'a year ago', 'in 1990' itp.",
                "W przypadku czasowników regularnych, do formy podstawowej czasownika dodajemy 'ed'. Na przykład: He worked in that company for 5 years. Dla czasowników nieregularnych musimy znać ich drugą formę. Na przykład: He saw a movie yesterday.\n\n" +
                        "W tworzeniu formy przeczącej i pytającej używamy pomocniczego czasownika 'did'. Na przykład: I did not (didn't) know about the meeting. Did you see the concert last night?",
                "1. I visited my grandparents last weekend.\n" +
                        "2. She didn't go to the party yesterday.\n" +
                        "3. They studied for the test all night.\n" +
                        "4. He didn't eat breakfast this morning.\n" +
                        "5. Did you see the concert last night?\n" +
                        "6. We watched a movie yesterday.\n" +
                        "7. I didn't understand the question.\n" +
                        "8. They didn't have a car when they were young.\n" +
                        "9. She studied all night for the test.\n" +
                        "10. He lived in Spain for 10 years."
            ),
            GrammarTime(
                "Past Perfect",
                "Past Perfect jest używany do opisania czynności, która została zakończona przed innym wydarzeniem w przeszłości. Czas ten jest również używany do wyrażania czynności, które nie doszły do skutku, mimo że mogły mieć miejsce.\n\n" +
                        "Często używamy go razem ze słowami, które wskazują na czas w przeszłości, takie jak 'before', 'after', 'by the time', 'already' itp.",
                "Tworzymy Past Perfect używając had + past participle (trzecia forma czasownika). Dla czasowników regularnych, past participle jest takie same jak past simple (na przykład: worked, started). Dla czasowników nieregularnych musimy znać ich trzecią formę. Na przykład: He had seen a movie before he went to bed.\n\n" +
                        "W tworzeniu formy przeczącej dodajemy not po 'had'. Na przykład: I had not (hadn't) seen her before yesterday.",
                "1. She had already left when I arrived.\n" +
                        "2. They hadn't seen the movie before they went to the theatre.\n" +
                        "3. We had studied English before we moved to England.\n" +
                        "4. I hadn't met him until yesterday.\n" +
                        "5. Had you ever visited Paris before you moved there?\n" +
                        "6. I had finished my work by the time he called.\n" +
                        "7. They hadn't travelled by plane before they went to Spain.\n" +
                        "8. She had never seen a polar bear before she visited the zoo.\n" +
                        "9. I had already made dinner when she arrived.\n" +
                        "10. Had you ever seen a ghost before last night?"
            ),
            GrammarTime(
                "Past Perfect Continuous",
                "Past Perfect Continuous jest używany do wyrażania czynności, która rozpoczęła się w przeszłości i trwała aż do pewnego momentu, również w przeszłości. Używamy go również do wyrażenia powtarzających się czynności, które miały miejsce przed pewnym momentem w przeszłości.\n\n" +
                        "Często używamy go z wyrażeniami takimi jak 'for', 'since', 'by the time', 'all day', itp.",
                "Tworzymy Past Perfect Continuous używając had been + verb-ing (present participle). Na przykład: She had been studying for 3 hours when her friend called.\n\n" +
                        "W tworzeniu formy przeczącej dodajemy not po 'had'. Na przykład: They had not (hadn't) been living there for a long time.",
                "1. I had been working all day, so I was very tired.\n" +
                        "2. They had been living in London before they moved to Paris.\n" +
                        "3. She had been studying for three hours when her friend called.\n" +
                        "4. Had you been waiting long before the bus arrived?\n" +
                        "5. The kids had been playing in the garden all day.\n" +
                        "6. We had not been eating before they came.\n" +
                        "7. She had been reading the book for two hours before she fell asleep.\n" +
                        "8. I had been trying to call you all day.\n" +
                        "9. They had been arguing before she walked out.\n" +
                        "10. It had been raining for hours when he decided to go out."
            ),

            GrammarTime(
                "Future Simple",
                "Future Simple używamy do wyrażania przyszłych zdarzeń, które są niezależne od nas, nie zaplanowane. Używamy go do wyrażania przewidywań, obietnic, ofert, decyzji, strachów, nadziei, itp.\n\n" +
                        "Często używamy go z wyrażeniami takimi jak 'I think', 'probably', 'maybe', 'I'm sure', itp.",
                "Tworzymy Future Simple używając will + verb (base form). Na przykład: I will call you when I arrive. Do tworzenia formy przeczącej dodajemy not po 'will'. Na przykład: I will not (won't) be at home tomorrow.\n\n" +
                        "W formie pytającej 'will' pojawia się przed podmiotem. Na przykład: Will you be at the party?",
                "1. I will call you when I arrive.\n" +
                        "2. They won't be at home tomorrow.\n" +
                        "3. Will you be at the party?\n" +
                        "4. She won't pass the exam, she didn't study at all.\n" +
                        "5. I will finish my work and then we can go out.\n" +
                        "6. I think it will rain tomorrow.\n" +
                        "7. I'm sure you will love this movie.\n" +
                        "8. He won't be happy to hear the news.\n" +
                        "9. Will they arrive on time?\n" +
                        "10. I won't be able to come to your party, I'm sorry."
            ),
        )
    }
}
