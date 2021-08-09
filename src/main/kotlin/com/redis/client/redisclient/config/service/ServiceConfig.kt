package com.redis.client.redisclient.config.service

import com.redis.client.redisclient.service.util.ProtocolCommandBuilder
import com.redis.client.redisclient.service.RedisServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ServiceConfig {

    @Bean
    fun commandBuilder() = ProtocolCommandBuilder()

    @Bean
    fun redisService() = RedisServiceImpl(commandBuilder())
}