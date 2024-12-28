package com.example.ai_luna_android.presentation.ui.screen.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class HomeUiState(
    val isLoading: Boolean = false,
    val error: String? = null
    // TODO: 추가적인 상태 정보가 필요하다면 여기에 추가
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    // TODO: 필요한 Repository 주입
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    // TODO: 필요한 비즈니스 로직 추가
}