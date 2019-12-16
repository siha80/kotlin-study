package com.siha80.kotlin.study.kotlinexam.routehandler

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@Component
class HelloWorldRouteHandler {
    fun helloWorld(req: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().bodyValue("hello, world")
    }
}