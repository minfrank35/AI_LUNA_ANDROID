package com.example.ai_luna_android.presentation.ui.screen.intro

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.ai_luna_android.R
import com.example.ai_luna_android.presentation.ui.component.CircularProgressBar

@Composable
fun IntroScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var progress by remember { mutableStateOf(0f) }

    // 애니메이션 설정
    val progressAnimation by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(
            durationMillis = 1000,
            easing = FastOutSlowInEasing
        ),
        finishedListener = {
            // 애니메이션이 끝나면 홈 화면으로 이동
            navController.navigate("home") {
                popUpTo("intro") { inclusive = true }
            }
        }
    )

    // 프로그레스 시작
    LaunchedEffect(Unit) {
        progress = 100f
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // 배경 이미지
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // 프로그레스 바
        CircularProgressBar(
            percentage = progressAnimation,
            modifier = Modifier.size(300.dp),
            backgroundColor = Color.Gray.copy(alpha = 0.3f),
            progressColor = Color.White,
            progressBlurColor = Color(0xFF11DCE8)
        )
    }
}