package com.redis.client.redisclient.api.dto

import io.swagger.v3.oas.annotations.media.Schema

/**
 * Error response
 */
@Schema(description = "Error response")
data class ErrorDtoRs(
        val type: String? = null,
        val message: String?)