package com.example.hexagonal.global.env.redis

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "redis")
class RedisProperties(
    val host: String,
    val port: Int
)