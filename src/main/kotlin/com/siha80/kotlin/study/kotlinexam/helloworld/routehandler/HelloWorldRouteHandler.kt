package com.siha80.kotlin.study.kotlinexam.helloworld.routehandler

import com.siha80.kotlin.study.kotlinexam.helloworld.event.HelloWorldPostRequest
import com.siha80.kotlin.study.kotlinexam.helloworld.service.HelloWorldService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class HelloWorldRouteHandler(
        private val helloWorldService: HelloWorldService
) {
    fun helloWorld(req: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().body(BodyInserters.fromValue(helloWorldService.helloWorld())).log()
    }

    fun postHelloWorld(req: ServerRequest): Mono<ServerResponse> {
        return req.bodyToMono(HelloWorldPostRequest::class.java)
                .flatMap { ServerResponse.ok().bodyValue("hello, ${it.name}") }
    }
}