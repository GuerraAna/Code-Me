package com.codeme.cmp

private val platform = object : Platform {
    override val name: String
        get() = "Desktop (JVM)"
}

actual fun getPlatform(): Platform = platform
