package com.siha80.kotlin.study.kotlinexam

import arrow.core.Either
import arrow.core.Left
import arrow.core.Right
import arrow.instances.list.foldable.foldLeft
import kotlinx.coroutines.future.await
import kotlinx.coroutines.runBlocking
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration
import java.util.concurrent.CompletableFuture

@SpringBootApplication
class KotlinexamApplication

fun main(args: Array<String>) {
//    runApplication<KotlinexamApplication>(*args)
//    getValue(10, Logger.CONSOLE)

    val divided = divide(10, 0).fold(
            {le -> le.message },
            {r -> r.toString()}
    )

    println(divided)

    val listOfInt = listOf(1, 2, 3)
    val joinWithPipe = listOfInt.map { it * 2 }.joinToString(separator = ",")
    println(joinWithPipe)

    println(listOfInt.foldLeft(0, { i1, i2 -> i1 + i2 }))
    val f = { i1: Int, i2: Int, i3: Int -> i1 + i2 + i3}
    println(f(10, 20, 30))

    runBlocking {
        println(httpTest().body())
    }
}

suspend fun httpTest(): HttpResponse<String> {
    val client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(2))
            .build()

    val request = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("https://www.google.com"))
            .timeout(Duration.ofSeconds(3))
            .build()

    val response: CompletableFuture<HttpResponse<String>> = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
    return response.await()
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
