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
import to.holepunch.bare.kit.Worklet
import to.holepunch.bare.kit.IPC
import java.nio.ByteBuffer
import java.nio.charset.StandardCharsets

class MainActivity : AppCompatActivity() {
    private lateinit var chatList: RecyclerView
    private lateinit var messageInput: EditText
    private lateinit var sendButton: ImageButton
    private lateinit var adapter: MessageAdapter

    private var worklet: Worklet? = null
    private var ipc: IPC? = null

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

        try {
            worklet = Worklet(null)
            assets.open("app.bundle").use { inStream ->
                worklet!!.start("/app.bundle", inStream, null)
            }
            ipc = IPC(worklet)
            ipc!!.readable {
                val buf = ipc!!.read()
                if (buf != null) {
                    val bytes = ByteArray(buf.remaining())
                    buf.get(bytes)
                    val msg = String(bytes, StandardCharsets.UTF_8)
                    runOnUiThread {
                        adapter.append(Message("[bee] $msg", true))
                        chatList.scrollToPosition(adapter.itemCount - 1)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        fun sendCurrent() {
            val text = messageInput.text.toString().trim()
            if (text.isEmpty()) return
            adapter.append(Message(text, false))
            messageInput.setText("")
            chatList.scrollToPosition(adapter.itemCount - 1)

            // Try to write the message to the worklet IPC
            try {
                val buf = ByteBuffer.wrap(text.toByteArray(StandardCharsets.UTF_8))
                ipc?.writable {
                    ipc?.write(buf)
                }
            } catch (_: Exception) {}
        }

        sendButton.setOnClickListener { sendCurrent() }
        messageInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) { sendCurrent(); true } else false
        }
    }

    override fun onPause() {
        super.onPause()
        try { worklet?.suspend() } catch (_: Exception) {}
    }

    override fun onResume() {
        super.onResume()
        try { worklet?.resume() } catch (_: Exception) {}
    }

    override fun onDestroy() {
        try { worklet?.terminate() } catch (_: Exception) {}
        worklet = null
        super.onDestroy()
    }
}
