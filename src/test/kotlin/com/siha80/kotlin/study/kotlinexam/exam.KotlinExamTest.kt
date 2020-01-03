package com.siha80.kotlin.study.kotlinexam

import arrow.core.Either
import arrow.core.Left
import arrow.core.Right
import com.siha80.kotlin.study.kotlinexam.adt.OptionAdt
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

    @Test
    fun optionAdt() {
        val optionAdt = OptionAdt.apply("test")

        val result = when(optionAdt) {
            is OptionAdt.Some -> "some"
            else -> "none"
        }

        println("RESULT: $result")
    }


    @Test
    fun test_currying() {
        val sum2ints: (Int) -> (Int) -> Int = { x -> { y -> x + y } }
        val add5 = sum2ints(5)
        val res = add5(7)

        println(res)
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
    
    val func = {i: Int -> i.toString()}
    
    val res = func(10)
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


