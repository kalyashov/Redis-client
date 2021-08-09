package com.redis.client.redisclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RedisClientApplication

fun main(args: Array<String>) {
    runApplication<RedisClientApplication>(*args)
}
