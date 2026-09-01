package com.codeme.cmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
