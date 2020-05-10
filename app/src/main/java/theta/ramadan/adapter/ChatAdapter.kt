package theta.ramadan.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.chat_list_item.view.*
import theta.ramadan.android.R
import theta.ramadan.android.ui.ChatFragment

class ChatAdapter(val context: Context) : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    var chatList: ArrayList<ChatFragment.ChatMessage> = arrayListOf()

    fun addChatList(chatListFromFragment: ArrayList<ChatFragment.ChatMessage>) {
        chatList = chatListFromFragment
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {

        val view: View =
            LayoutInflater.from(context).inflate(R.layout.chat_list_item, parent, false)
        return ChatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {

        val chatItem = chatList[position]

        val senderNameText = holder.itemView.userName
        val messageDate = holder.itemView.chatDate
        val messageText = holder.itemView.chatMessage

        senderNameText.text = chatItem.sender
        messageDate.text = chatItem.date
        messageText.text = chatItem.message



    }


    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }
}
