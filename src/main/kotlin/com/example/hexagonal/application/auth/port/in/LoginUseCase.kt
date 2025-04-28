package com.example.hexagonal.application.auth.port.`in`

import com.example.hexagonal.adapter.`in`.auth.dto.request.LoginRequest
import com.example.hexagonal.global.security.jwt.dto.TokenResponse

interface LoginUseCase {
    fun login(request: LoginRequest): TokenResponse
}