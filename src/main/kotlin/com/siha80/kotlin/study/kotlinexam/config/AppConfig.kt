package com.siha80.kotlin.study.kotlinexam.config

import com.siha80.kotlin.study.kotlinexam.route.helloWorldRoute
import com.siha80.kotlin.study.kotlinexam.routehandler.HelloWorldRouteHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class AppConfig {
    @Bean
    fun routeFunction (
            helloWorldHandler: HelloWorldRouteHandler
    ): RouterFunction<ServerResponse> {
        return helloWorldRoute(helloWorldHandler)
    }

}