package theta.ramadan.interfaces

import theta.ramadan.android.ui.ChatFragment

interface OnChatItemClickListener {
    fun onItemClick(chat: ChatFragment.ChatMessage)
}
