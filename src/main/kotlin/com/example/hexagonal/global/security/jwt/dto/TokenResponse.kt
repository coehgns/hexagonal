package com.example.hexagonal.global.security.jwt.dto

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)
