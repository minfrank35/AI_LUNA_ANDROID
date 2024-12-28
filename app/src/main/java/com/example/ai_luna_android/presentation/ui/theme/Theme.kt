package com.example.ai_luna_android.presentation.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Theme.kt
private val DarkColorScheme = darkColorScheme(
    primary = MysticPurple,
    onPrimary = Color.White,
    primaryContainer = DeepPurple,
    onPrimaryContainer = LightPurple,
    secondary = SoftGold,
    onSecondary = DeepPurple,
    secondaryContainer = MysticGold,
    onSecondaryContainer = Color.White,
    tertiary = MysticSilver,
    background = DarkBg,
    surface = DeepPurple,
    onSurface = LightPurple
)

private val LightColorScheme = lightColorScheme(
    primary = MysticPurple,
    onPrimary = Color.White,
    primaryContainer = LightPurple,
    onPrimaryContainer = DeepPurple,
    secondary = MysticGold,
    onSecondary = DeepPurple,
    secondaryContainer = SoftGold,
    onSecondaryContainer = DeepPurple,
    tertiary = MysticSilver,
    background = LightPurple,
    surface = Color.White,
    onSurface = DeepPurple
)

@Composable
fun AI_LUNA_ANDROIDTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}