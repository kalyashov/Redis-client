package com.redis.client.redisclient.service.util

import java.nio.charset.StandardCharsets

/**
 * Recursive parsing Redis query result
 */
fun parseRedisQueryResult(result: Any, resultStr: String): String {
    var res = resultStr

    if (result is Int || result is Long || result is String || result is Boolean) {
        res += result.toString() + "\n"
    } else if (result is ByteArray) {
        res += result.toString(StandardCharsets.UTF_8) + "\n"
    } else if (result is List<*>) {
        for (obj in result) {
            res = parseRedisQueryResult(obj!!, res)
        }
        res += "-----------------------------------------------------------------\n"
    }

    return res
}