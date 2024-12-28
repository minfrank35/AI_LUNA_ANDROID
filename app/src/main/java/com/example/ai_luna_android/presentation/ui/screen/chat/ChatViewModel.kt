// ui/screen/chat/ChatViewModel.kt
package com.example.ai_luna_android.presentation.ui.screen.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ai_luna_android.presentation.ui.screen.chat.model.ChatMessage
import com.example.ai_luna_android.presentation.ui.screen.chat.model.MessageType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    // private val chatRepository: ChatRepository // TODO: Repository 구현 후 주입
) : ViewModel() {
    private val _messages = MutableStateFlow<List<ChatMessage>>(emptyList())
    val messages: StateFlow<List<ChatMessage>> = _messages.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _inputText = MutableStateFlow("")
    val inputText: StateFlow<String> = _inputText.asStateFlow()

    fun setInputText(text: String) {
        _inputText.value = text
    }

    fun startInitialChat(questionId: Int? = null) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // TODO: Repository 구현 후 실제 API 호출로 대체
                val initialMessage = "안녕하세요! 타로 상담을 시작하겠습니다."
                _messages.value = listOf(
                    ChatMessage(
                        id = UUID.randomUUID().toString(),
                        content = initialMessage,
                        type = MessageType.AI,
                        isActionable = true
                    )
                )
            } catch (e: Exception) {
                // TODO: 에러 처리
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun sendMessage(message: String) {
        if (message.isBlank()) return

        viewModelScope.launch {
            // 사용자 메시지 추가
            _messages.value = _messages.value + ChatMessage(
                id = UUID.randomUUID().toString(),
                content = message,
                type = MessageType.USER
            )
            
            _isLoading.value = true
            try {
                // TODO: Repository 구현 후 실제 API 호출로 대체
                val response = "AI 응답 메시지입니다."
                _messages.value = _messages.value + ChatMessage(
                    id = UUID.randomUUID().toString(),
                    content = response,
                    type = MessageType.AI
                )
            } catch (e: Exception) {
                // TODO: 에러 처리
            } finally {
                _isLoading.value = false
                _inputText.value = ""
            }
        }
    }
}