package com.redis.client.redisclient.service

/**
 * Service for working with Redis
 */
interface RedisService {

    /**
     * Connect to Redis
     *
     * @param host - Redis host
     * @param port - Redis port
     * @param password - Redis password
     * @param database - Redis database
     */
    fun connect(host: String, port: String, password: String?, database: Int)

    /**
     * Send command to Redis
     *
     * @param commandRaw - Redis command
     * @param paramsRaw - command parameters
     *
     * @return command result
     */
    fun sendCommand(commandRaw: String, paramsRaw: String? = null): String
}