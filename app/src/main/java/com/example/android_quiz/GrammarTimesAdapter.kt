package com.example.android_quiz

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GrammarTimesAdapter(private val grammarTimes: List<GrammarTime>) :
    RecyclerView.Adapter<GrammarTimesAdapter.ViewHolder>() {

        class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
            val titleTextView: TextView = itemView.findViewById(R.id.tv_title)
            val descriptionTextView: TextView = itemView.findViewById(R.id.tv_description)
            val viewRulesButton: Button = itemView.findViewById(R.id.btn_view_rules)
            val viewExamplesButton: Button = itemView.findViewById(R.id.btn_view_examples)
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grammar_time, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount() = grammarTimes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val grammarTime = grammarTimes[position]
        holder.titleTextView.text = grammarTime.title
        holder.descriptionTextView.text = grammarTime.description

        holder.viewRulesButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, RulesActivity::class.java)
            intent.putExtra("rules", grammarTime.rules)
            holder.itemView.context.startActivity(intent)
        }
        holder.viewExamplesButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, ExamplesActivity::class.java)
            intent.putExtra("examples", grammarTime.examples)
            holder.itemView.context.startActivity(intent)
        }

    }
}