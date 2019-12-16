package com.siha80.kotlin.study.kotlinexam.helloworld.route

import com.siha80.kotlin.study.kotlinexam.helloworld.routehandler.HelloWorldRouteHandler
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

fun helloWorldRoute(handler: HelloWorldRouteHandler): RouterFunction<ServerResponse> {
    return router {
        GET("/test/helloworld", handler::helloWorld)
    }
}
