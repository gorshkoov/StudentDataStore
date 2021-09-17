package ru.example.studentdatastore.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.example.studentdatastore.R


class ListViewHolder(itemView: View, clickListener: (View) -> Unit) :
    RecyclerView.ViewHolder(itemView) {
    private val textView: TextView = itemView.findViewById(R.id.text_view)

    init {
        textView.setOnClickListener(clickListener)
    }

    fun bind(item: ListItem) {
        textView.text = item.text
        textView.tag = item.id
    }
}