package com.example.ai_luna_android.presentation.ui.screen.chat.model

sealed class MessageType {
    object AI : MessageType()
    object USER : MessageType()
}

data class ChatMessage(
    val id: String,
    val content: String,
    val type: MessageType,
    val isActionable: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)