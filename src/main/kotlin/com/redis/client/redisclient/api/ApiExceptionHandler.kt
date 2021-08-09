package com.redis.client.redisclient.api

import com.redis.client.redisclient.api.dto.ErrorDtoRs
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import redis.clients.jedis.exceptions.JedisException

@ControllerAdvice
class ApiExceptionHandler {

    companion object {
        val logger = LoggerFactory.getLogger(this::class.java)!!
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun internalServerError(e: Exception): ErrorDtoRs {
        logger.error("An error occurred processing the REST request", e)
        return ErrorDtoRs(type = "APP_ERROR", message = e.message)
    }

    @ExceptionHandler(JedisException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun redisError(e: Exception): ErrorDtoRs {
        logger.error("An error occurred processing the Redis query", e)
        return ErrorDtoRs(type = "REDIS_ERROR", message = e.message)
    }
}