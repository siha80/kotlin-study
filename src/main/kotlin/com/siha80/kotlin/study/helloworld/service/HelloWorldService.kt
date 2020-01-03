package com.siha80.kotlin.study.helloworld.service

import org.springframework.stereotype.Service

@Service
class HelloWorldService {
    fun helloWorld(): String {
        Thread.sleep(5000L)
        return "hello, world"
    }
}