package org.healthscience.healthcues.chat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.healthscience.healthcues.R

class MessageAdapter(private val items: MutableList<Message>) : RecyclerView.Adapter<MessageAdapter.VH>() {

    companion object {
        private const val TYPE_AGENT = 1
        private const val TYPE_USER = 2
    }

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val text: TextView = v.findViewById(R.id.messageText)
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].fromAgent) TYPE_AGENT else TYPE_USER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val layout = if (viewType == TYPE_AGENT) R.layout.row_message_agent else R.layout.row_message_user
        val v = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.text.text = items[position].text
    }

    override fun getItemCount(): Int = items.size

    fun append(m: Message) {
        items.add(m)
        notifyItemInserted(items.size - 1)
    }
}
