package com.siha80.kotlin.study.helloworld.service

import com.siha80.kotlin.study.annotation.AopLogging
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.time.Duration

@Service
@AopLogging
class HelloWorldService {
    fun helloWorld(): Mono<String> {
        return Mono.just("hello, world").delayElement(Duration.ofSeconds(10))
    }
}