package com.example.ai_luna_android.presentation.ui.screen.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem("home", Icons.Default.Home, "홈")
    object History : BottomNavItem("history", Icons.Default.List, "기록")
    object Profile : BottomNavItem("profile", Icons.Default.Person, "프로필")
}

data class QuickQuestion(
    val id: Int,
    val question: String,
    val category: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToChat: (Int?) -> Unit
) {





}

@Composable
private fun getQuestionIcon(category: String) {
    val icon = when (category) {
        "연애" -> "❤️"
        "커리어" -> "💼"
        "운세" -> "🔮"
        "고민" -> "💭"
        else -> "✨"
    }
    Text(
        text = icon,
        style = MaterialTheme.typography.titleLarge
    )
}