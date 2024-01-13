import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_quiz.VocabularyItem
import com.example.android_quiz.R


class VocabularyAdapter(private val vocabularyItems: List<VocabularyItem>) :
    RecyclerView.Adapter<VocabularyAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wordTextView: TextView = view.findViewById(R.id.word_text)
        val translationTextView: TextView = view.findViewById(R.id.translation_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_vocabulary, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = vocabularyItems[position]
        holder.wordTextView.text = item.word
        holder.translationTextView.text = item.translation
    }

    override fun getItemCount() = vocabularyItems.size
}
