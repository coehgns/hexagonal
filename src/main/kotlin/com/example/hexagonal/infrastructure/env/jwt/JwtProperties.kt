package com.example.hexagonal.infrastructure.env.jwt

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    val secretKey: String,
    val accessExp: Long,
    val refreshExp: Long,
    val header: String,
    val prefix: String
)