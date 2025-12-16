package org.healthscience.healthcues

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.healthscience.healthcues.chat.Message
import org.healthscience.healthcues.chat.MessageAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var chatList: RecyclerView
    private lateinit var messageInput: EditText
    private lateinit var sendButton: ImageButton
    private lateinit var adapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chatList = findViewById(R.id.chatList)
        messageInput = findViewById(R.id.messageInput)
        sendButton = findViewById(R.id.sendButton)

        adapter = MessageAdapter(mutableListOf(
            Message("Hi, I am beebee. How can I help?", true)
        ))
        chatList.layoutManager = LinearLayoutManager(this).apply { stackFromEnd = true }
        chatList.adapter = adapter

        fun sendCurrent() {
            val text = messageInput.text.toString().trim()
            if (text.isEmpty()) return
            adapter.append(Message(text, false))
            messageInput.setText("")
            chatList.scrollToPosition(adapter.itemCount - 1)
            // Stub beebee reply for now
            chatList.postDelayed({
                adapter.append(Message("beebee received: $text", true))
                chatList.scrollToPosition(adapter.itemCount - 1)
            }, 400)
        }

        sendButton.setOnClickListener { sendCurrent() }
        messageInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) { sendCurrent(); true } else false
        }
    }
}
