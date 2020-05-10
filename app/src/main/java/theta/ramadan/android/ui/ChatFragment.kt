package theta.ramadan.android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_chat.view.*
import theta.ramadan.adapter.ChatAdapter
import theta.ramadan.android.R

/**
 * A simple [Fragment] subclass.
 */
class ChatFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.chatProgressBar.visibility = View.VISIBLE
        val chatAdapter = ChatAdapter(activity?.applicationContext!!)
        chatAdapter.addChatList(getChatMessagesLocally())

        view.chatRecyclerView.layoutManager = LinearLayoutManager(activity)
        view.chatRecyclerView.adapter = chatAdapter
        view.chatProgressBar.visibility = View.GONE


    }


    private fun getChatMessagesLocally(): ArrayList<ChatMessage> {
        val chatList = arrayListOf<ChatMessage>()

        chatList.add(
            ChatMessage(
                sender = "Salman",
                date = "23.21.1212",
                message = "Hello, this is my message"
            )
        )
        chatList.add(
            ChatMessage(
                sender = "Ali",
                date = "23.2.1212",
                message = "Hello, this is my message"
            )
        )
        chatList.add(
            ChatMessage(
                sender = "Theta",
                date = "2.28.1212",
                message = "Hello, this is my message"
            )
        )
        chatList.add(
            ChatMessage(
                sender = "Umer",
                date = "23.6.1212",
                message = "Hello, this is my message"
            )
        )
        chatList.add(
            ChatMessage(
                sender = "Hassan",
                date = "6.23.1212",
                message = "Hello, this is my message"
            )
        )
        chatList.add(
            ChatMessage(
                sender = "Abid",
                date = "3.12.1912",
                message = "Hello, this is my message"
            )
        )
        chatList.add(
            ChatMessage(
                sender = "Ahmed",
                date = "3.11.1712",
                message = "Hello, this is my message"
            )
        )
        chatList.add(
            ChatMessage(
                sender = "Imran",
                date = "2.21.1712",
                message = "Hello, this is my message"
            )
        )
        chatList.add(
            ChatMessage(
                sender = "Adnan",
                date = "2.2.1612",
                message = "Hello, this is my message"
            )
        )
        chatList.add(
            ChatMessage(
                sender = "Iqra",
                date = "4.4.1512",
                message = "Hello, this is my message"
            )
        )

        return chatList
    }


    data class ChatMessage(var sender: String, var date: String, var message: String)

}
