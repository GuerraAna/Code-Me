package com.codeme.cmp.portfolio

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object PortfolioColors {
    val Background = Color(0xFF0B0F1A)
    val BackgroundGlow = Color(0xFF1B2140)
    val Surface = Color(0xFF131826)
    val SurfaceBorder = Color(0xFF232A3D)
    val TextPrimary = Color(0xFFF2F4F8)
    val TextSecondary = Color(0xFFA0A8BC)
    val TextMuted = Color(0xFF6B7387)
    val Accent = Color(0xFF6C7CFF)
    val AccentLight = Color(0xFF8B9BFF)
    val AccentEnd = Color(0xFFA26BFF)
    val Success = Color(0xFF2DD4A3)
    val ChipBackground = Color(0xFF1D2436)

    val accentGradient = Brush.horizontalGradient(listOf(Accent, AccentEnd))
    val titleGradient = Brush.horizontalGradient(listOf(AccentLight, AccentEnd))
}
