package com.siha80.kotlin.study.kotlinexam.helloworld.routehandler

import com.siha80.kotlin.study.kotlinexam.helloworld.service.HelloWorldService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class HelloWorldRouteHandler(
        private val helloWorldService: HelloWorldService
) {
    fun helloWorld(req: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().bodyValue(helloWorldService.helloWorld())
    }
}