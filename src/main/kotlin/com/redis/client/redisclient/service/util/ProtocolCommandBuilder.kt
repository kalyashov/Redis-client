package com.redis.client.redisclient.service.util

import redis.clients.jedis.Protocol
import redis.clients.jedis.commands.ProtocolCommand

/**
 * Command builder for Jedis
 */
class ProtocolCommandBuilder {

    fun build(command: String): ProtocolCommand {
        return try {
            Protocol.Command.valueOf(command.toUpperCase())
        } catch (ex: Exception) {
            RediSearchProtocolCommand.fromValue(command.toUpperCase())
        }
    }
}