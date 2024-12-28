package com.example.ai_luna_android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ai_luna_android.presentation.ui.screen.chat.ChatScreen
import com.example.ai_luna_android.presentation.ui.screen.home.HomeScreen
import com.example.ai_luna_android.presentation.ui.theme.AI_LUNA_ANDROIDTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AI_LUNA_ANDROIDTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable("home") {
                            HomeScreen(
                                onNavigateToChat = { questionId ->
                                    if (questionId == null) {
                                        navController.navigate("chat")
                                    } else {
                                        navController.navigate("chat?questionId=$questionId")
                                    }
                                }
                            )
                        }
                        composable(
                            route = "chat?questionId={questionId}",
                            arguments = listOf(
                                navArgument("questionId") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                            ChatScreen(
                                questionId = it.arguments?.getInt("questionId")?.takeIf { id -> id != -1 },
                                onNavigateToAr = { navController.navigate("ar") },
                                onBackPress = { navController.popBackStack() }
                            )
                        }
                        composable("ar") {
                            // AR 화면 구현 예정
                            // ARScreen()
                        }
                    }
                }
            }
        }
    }
}