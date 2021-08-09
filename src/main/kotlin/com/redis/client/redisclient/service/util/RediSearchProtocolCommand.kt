package com.redis.client.redisclient.service.util

import redis.clients.jedis.commands.ProtocolCommand
import redis.clients.jedis.util.SafeEncoder
import java.lang.IllegalArgumentException

/**
 * RediSearch commands for Jedis
 */
enum class RediSearchProtocolCommand: ProtocolCommand {
    
    FT_CREATE,
    FT_SEARCH,
    FT_AGGREGATE,
    FT_EXPLAIN,
    FT_EXPLAINCLI,
    FT_PROFILE,
    FT_ALTER_SCHEMA_ADD("FT.ALTER SCHEMA ADD"),
    FT_DROPINDEX,
    FT_ALIASADD,
    FT_ALIASUPDATE,
    FT_ALIASDEL,
    FT_TAGVALS,
    FT_SUGADD,
    FT_SUGGET,
    FT_SUGDEL,
    FT_SUGLEN,
    FT_SYNUPDATE,
    FT_SYNDUMP,
    FT_SPELLCHECK,
    FT_DICTADD,
    FT_DICTDEL,
    FT_DICTDUMP,
    FT_INFO,
    FT_LIST("FT._LIST"),
    FT_CONFIG,
    FT_ADD,
    FT_DEL,
    FT_DROP,
    FT_GET,
    FT_MGET,
    FT_SYNADD,
    HSET;

    constructor()

    constructor(commandRaw: String) {
        this.command = commandRaw
    }

    private var command = name.replace("_",".")
    private var raw: ByteArray = SafeEncoder.encode(command)

    override fun getRaw(): ByteArray? {
        return raw
    }

    companion object {
        fun fromValue(commandRaw: String): ProtocolCommand {
            values().forEach {
                if (it.command == commandRaw.toUpperCase()) {
                    return it
                }
            }

            throw IllegalArgumentException("Unknown Redis command")
        }
    }
}