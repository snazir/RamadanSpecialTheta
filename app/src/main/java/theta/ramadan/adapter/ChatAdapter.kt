package theta.ramadan.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.chat_list_item.view.*
import theta.ramadan.android.R
import theta.ramadan.android.ui.ChatFragment
import theta.ramadan.interfaces.OnChatItemClickListener

class ChatAdapter(val context: Context, private val clickListener: OnChatItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var chatList: ArrayList<ChatFragment.ChatMessage> = arrayListOf()

    fun addChatList(chatListFromFragment: ArrayList<ChatFragment.ChatMessage>) {
        chatList = chatListFromFragment
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = View(context)
        if (viewType == 0) {
            view =
                LayoutInflater.from(context).inflate(R.layout.chat_list_item, parent, false)
            return ChatViewHolder(view)
        } else if (viewType == 1) {
            view =
                LayoutInflater.from(context).inflate(R.layout.chat_list_item2, parent, false)
            return SecondChatViewHolder(view)
        }

        return ChatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chatItem = chatList[position]

        if (holder.itemViewType == 0) {
            val chatHolder = holder as ChatViewHolder

            val senderNameText = holder.itemView.userName
            val messageDate = holder.itemView.chatDate
            val messageText = holder.itemView.chatMessage

            senderNameText.text = chatItem.sender
            messageDate.text = chatItem.date
            messageText.text = chatItem.message

            holder.itemView.setOnClickListener {
                clickListener.onItemClick(chatItem)
            }

        } else if (holder.itemViewType == 1) {
            val chatHolder = holder as SecondChatViewHolder
            chatHolder.itemView.setOnClickListener {
                clickListener.onItemClick(chatItem) // this listener can be dofferent for different type
            }

        }

    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) 0
        else 1

    }

    class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    class SecondChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

}
