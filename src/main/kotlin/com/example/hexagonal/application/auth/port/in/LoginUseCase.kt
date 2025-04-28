package com.example.hexagonal.application.auth.port.`in`

import com.example.hexagonal.adapter.`in`.auth.dto.request.LoginRequest

interface LoginUseCase {
    fun login(request: LoginRequest)
}