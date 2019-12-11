package com.siha80.kotlin.study.kotlinexam

import arrow.core.Either
import arrow.core.Left
import arrow.core.Right
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class KotlinExamTest {
    @Test
    @DisplayName("kotlin enum test")
    fun makeEnum() {
        println("${Color.RED}")
    }

    @Test
    fun printEitherLeft() {
        println(divide(10, 0))
    }

    @Test
    fun printEitherRight() {
        println(divide(10, 3))
    }
}

enum class Color {
    RED,
    GREEN,
    BLUE
}

fun divide(number: Int, divider: Int): Either<Throwable, Int> {
    if(divider == 0) {
        return Left(ArithmeticException("divide by zero"))
    } else {
        return Right(number / divider)
    }
}

fun getValue(number: Int, logger: Logger): String {
    val result = "Input: $number"
    logger.print(result, "test")

    return result
}

enum class Logger {
    CONSOLE;

    val print get() = { msg: String, arg1: String -> println("$msg, $arg1") }
}
