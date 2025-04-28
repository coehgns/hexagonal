package com.example.hexagonal.global.security.jwt.entity

import jakarta.persistence.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

@RedisHash(value = "refresh")
class RefreshToken(
    @Id
    val id: String,

    @Indexed
    var token: String,

    @TimeToLive
    var ttl: Long
)