package com.example.hexagonal.global.config.repository

import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories

@Configuration
@EnableRedisRepositories(
    basePackages = ["com.example.hexagonal.global.security.jwt.entity.repository"]
)
class RedisRepositoryConfig