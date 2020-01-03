package com.siha80.kotlin.study.helloworld.route

import com.siha80.kotlin.study.annotation.AopLogging
import com.siha80.kotlin.study.helloworld.routehandler.HelloWorldRouteHandler
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@AopLogging
fun helloWorldRoute(handler: HelloWorldRouteHandler): RouterFunction<ServerResponse> {
    return router {
        GET("/test/helloworld", handler::helloWorld)
        GET("/test/hello/{name}", handler::helloWorldPathVariable)
        POST("/test/helloworld", handler::postHelloWorld)
    }
}
