package com.siha80.kotlin.study.config

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DatabaseConfig {
    @Bean
    fun connectionFactory(): PostgresqlConnectionFactory =
        PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration
                        .builder()
                        .host("ec2-54-195-252-243.eu-west-1.compute.amazonaws.com")
                        .port(5432)
                        .database("ddg6k4tgtmnniu")
                        .username("lzhvxrpuzsyyxs")
                        .password("33601e9e80d7b14db09ee76fe73d45a5dccda54227729c76b27653abbe08e789")
                        .build()
        )
}