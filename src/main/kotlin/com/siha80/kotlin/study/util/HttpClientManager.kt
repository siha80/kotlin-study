package com.siha80.kotlin.study.util

import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.future.await
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration

class HttpClientManager {
    companion object {
        fun of(url: String) {}
    }

    suspend fun <T> execute(request: HttpRequest, type: Class<T>): T {
        val client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(2))
                .build()

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply { res -> ObjectMapper().readValue(res.body(), type) }
                .await()
    }
}