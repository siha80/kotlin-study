package com.siha80.kotlin.study.config

import arrow.core.Option
import arrow.core.getOrElse
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono


@Component
@Aspect
class LoggingConfig {
    private val LOGGER = LoggerFactory.getLogger(this.javaClass.simpleName)

    @Pointcut("within(@com.siha80.kotlin.study.annotation.AopLogging *) "
    )
    fun aopLoggingPointCut() {

    }

    @Before("aopLoggingPointCut()")
    fun log_before(jp: JoinPoint): Unit {
        val argValue = Option(jp.args).map{ args -> args.map{ it.toString() }.joinToString() }.getOrElse { "NONE" }
        LOGGER.info("[CALLED ${jp.signature.toShortString()}] | [PARAM]: ${argValue}")
    }

    @AfterReturning("aopLoggingPointCut()", returning = "ret")
    fun log_after(jp: JoinPoint, ret: Any): Unit {
//        if (ret is Mono<*>) {
//            printMonoBody(jp, ret as Mono<Any>)
//        } else {
            printEndLog(jp, ret)
//        }
    }

    @AfterThrowing(value = "aopLoggingPointCut()", throwing = "e")
    fun loggingWebThrowing(jp: JoinPoint, e: Throwable) {
        printThrowableLog(jp, e)
    }

    private fun printEndLog(jp: JoinPoint, ret: Any) {
        LOGGER.info("[CALLED ${jp.signature.toShortString()}] | RETURN: ${Option(ret).getOrElse { "VOID" }}")
    }

    private fun printThrowableLog(jp: JoinPoint , e: Throwable) {
        LOGGER.error("[EXCEPT] ${jp.signature.toShortString()} | [TRACE] : ${Option(e).getOrElse{ "NULL" }}")
    }

    private fun printMonoBody(jp: JoinPoint, mono: Mono<Any>) {
        mono.subscribe{ data ->
            printEndLog(jp, data)
        }
    }


}