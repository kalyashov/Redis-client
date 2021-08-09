package com.redis.client.redisclient.service

import com.redis.client.redisclient.service.util.ProtocolCommandBuilder
import com.redis.client.redisclient.service.util.parseRedisQueryResult
import redis.clients.jedis.*
import java.lang.RuntimeException

/**
 * Service for working with Redis
 */
class RedisServiceImpl(private val commandBuilder: ProtocolCommandBuilder): RedisService {

    companion object {
        const val NO_CONNECTION_ERR_MSG = "There is no connection to Redis. Try to connect."
        var jedis: Jedis? = null
    }

    /**
     * Connect to Redis
     */
    override fun connect(host: String, port: String, password: String?, database: Int) {
        val hostAndPort = HostAndPort(host, port.toInt())
        val jedisClientConfig = DefaultJedisClientConfig.builder().database(database)

        if (!password.isNullOrEmpty()) {
            jedisClientConfig.password(password)
        }

        jedis = Jedis(hostAndPort, jedisClientConfig.build())
    }

    override fun sendCommand(commandRaw: String, paramsRaw: String?): String {
        if (jedis != null) {
            val command = commandBuilder.build(commandRaw)

            val result = if (!paramsRaw.isNullOrBlank()) {
                val commandParams = paramsRaw.trim().split("\\s+".toRegex())
                jedis!!.sendCommand(command, *commandParams.toTypedArray())
            }  else {
                jedis!!.sendCommand(command)
            }

            return if (result == null) "" else parseRedisQueryResult(result, "")
        } else {
            throw RuntimeException(NO_CONNECTION_ERR_MSG)
        }
    }
}