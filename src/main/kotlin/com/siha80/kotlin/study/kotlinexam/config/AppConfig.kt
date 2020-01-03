package com.siha80.kotlin.study.kotlinexam.config

import com.siha80.kotlin.study.kotlinexam.helloworld.route.helloWorldRoute
import com.siha80.kotlin.study.kotlinexam.helloworld.routehandler.HelloWorldRouteHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@Configuration
@EnableAspectJAutoProxy
@EnableWebFlux
class AppConfig {
    @Bean
    fun routeFunction (
            helloWorldHandler: HelloWorldRouteHandler
    ): RouterFunction<ServerResponse> {
        return helloWorldRoute(helloWorldHandler)
    }

}