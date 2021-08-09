package com.redis.client.redisclient.config.api

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:open-api.properties")
@ComponentScan("com.redis.client.redisclient")
class OpenApiConfiguration