package com.codeme.cmp

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import com.codeme.cmp.portfolio.PortfolioColors
import com.codeme.cmp.portfolio.PortfolioScreen

@Composable
fun App() {
    MaterialTheme(
        colors = darkColors(
            primary = PortfolioColors.Accent,
            background = PortfolioColors.Background,
            surface = PortfolioColors.Surface,
        ),
    ) {
        PortfolioScreen()
    }
}
