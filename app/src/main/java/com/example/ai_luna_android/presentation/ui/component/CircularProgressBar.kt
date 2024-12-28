package com.example.ai_luna_android.presentation.ui.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CircularProgressBar(
    percentage: Float,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Gray.copy(alpha = 0.3f),
    progressColor: Color = Color.White,
    progressBlurColor: Color = Color(0xFF11DCE8)
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        // 배경 원
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = backgroundColor,
                style = Stroke(width = 2.dp.toPx()),
                radius = size.minDimension / 2 - 4.dp.toPx()
            )
        }

        // 블러 효과가 있는 프로그레스 원
        Canvas(modifier = Modifier.fillMaxSize()) {
            val sweepAngle = (percentage / 100f) * 360f
            drawArc(
                color = progressBlurColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(
                    width = 11.dp.toPx(),
                    cap = StrokeCap.Round
                ),
                blendMode = BlendMode.Screen,
            )
        }

        // 메인 프로그레스 원
        Canvas(modifier = Modifier.fillMaxSize()) {
            val sweepAngle = (percentage / 100f) * 360f
            drawArc(
                color = progressColor,
                startAngle = -90f,
                sweepAngle = sweepAngle,
                useCenter = false,
                style = Stroke(
                    width = 8.dp.toPx(),
                    cap = StrokeCap.Round
                )
            )
        }

        // 중앙 텍스트
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "LUNA",
                style = MaterialTheme.typography.headlineLarge.copy(
                    color = Color.White
                )
            )
            Text(
                text = "AI Fortune Teller",
                style = MaterialTheme.typography.labelMedium.copy(
                    color = Color.White
                )
            )
        }
    }
}