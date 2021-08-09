package com.redis.client.redisclient.api

import com.redis.client.redisclient.service.RedisServiceImpl
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/redis/client")
class RedisClientController(private val redisService: RedisServiceImpl) {

    @Operation(summary = "Connecting to Redis")
    @GetMapping("/connect")
    fun connect(

        @Parameter(description = "Host")
        @RequestParam("host")
        host: String,

        @Parameter(description = "Port")
        @RequestParam("port", required = false, defaultValue = "6379")
        port: String,

        @Parameter(description = "Password")
        @RequestParam("password", required = false)
        password: String?,

        @Parameter(description = "Database")
        @RequestParam("database", required = false, defaultValue = "0")
        database: Int = 0
    ): String {
        redisService.connect(host, port, password, database)
        return "success"
    }

    @Operation(summary = "Execute query to Redis")
    @GetMapping("/query")
    suspend fun executeQuery(
        @Parameter(description = "Command")
        @RequestParam("command")
        command: String,

        @Parameter(description = "Parameters")
        @RequestParam("params", required = false)
        params: String?
    ): String {
        return redisService.sendCommand(command, params)
    }
}