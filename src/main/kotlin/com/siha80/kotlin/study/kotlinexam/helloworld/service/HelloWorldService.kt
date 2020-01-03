package com.siha80.kotlin.study.kotlinexam.helloworld.service

import org.springframework.stereotype.Service

@Service
class HelloWorldService {
    fun helloWorld(): String {
        Thread.sleep(1000L)
        return "hello, world"
    }
}