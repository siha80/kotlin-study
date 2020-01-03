package com.siha80.kotlin.study.config

import com.siha80.kotlin.study.helloworld.route.helloWorldRoute
import com.siha80.kotlin.study.helloworld.routehandler.HelloWorldRouteHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

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