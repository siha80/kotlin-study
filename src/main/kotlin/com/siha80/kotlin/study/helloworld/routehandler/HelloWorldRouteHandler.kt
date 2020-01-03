package com.siha80.kotlin.study.helloworld.routehandler

import com.siha80.kotlin.study.annotation.AopLogging
import com.siha80.kotlin.study.helloworld.event.HelloWorldPostRequest
import com.siha80.kotlin.study.helloworld.service.HelloWorldService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
@AopLogging
class HelloWorldRouteHandler (
        private val helloWorldService: HelloWorldService
) {
    private val LOGGER = LoggerFactory.getLogger(javaClass.simpleName)

    fun helloWorld(req: ServerRequest): Mono<ServerResponse> {
        return helloWorldService.helloWorld()
                .flatMap {
                    LOGGER.info("helloworld processed")
                    ServerResponse.ok().body(BodyInserters.fromValue(it))
                }
    }

    fun postHelloWorld(req: ServerRequest): Mono<ServerResponse> {
        return req.bodyToMono(HelloWorldPostRequest::class.java)
                .flatMap { ServerResponse.ok().bodyValue("hello, ${it.name}") }
    }

    fun helloWorldPathVariable(req: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().bodyValue("hello, ${req.pathVariable("name")}")
    }
}