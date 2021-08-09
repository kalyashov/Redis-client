package com.redis.client.redisclient.config.api

import com.redis.client.redisclient.api.RedisClientController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:open-api-ui.properties")
@ComponentScan("com.redis.client.redisclient")
class OpenApiUiConfiguration {

    companion object {
        const val description =
            "First you need to connect to Redis, and then make queries. </br></br>" +
            "<b>Available commands:</b> </br>" +
            "<a href=\"https://redis.io/commands\">https://redis.io/commands</a> </br>" +
            "<a href=\"https://oss.redislabs.com/redisearch/Commands\">https://oss.redislabs.com/redisearch/Commands/</a>"
    }

    @Bean
    fun clientV1() = defineOpenApi(
        group = "redis-client",
        packageName = RedisClientController::class.java.`package`.name,
        version = "1",
        title = "Redis client",
        description = description
    )
}