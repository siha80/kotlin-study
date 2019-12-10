package com.siha80.kotlin.study.kotlinexam

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class KotlinExamTest {
    @Test
    @DisplayName("kotlin enum test")
    fun makeEnum() {
        println("${Color.RED}")
    }
}

enum class Color {
    RED,
    GREEN,
    BLUE
}