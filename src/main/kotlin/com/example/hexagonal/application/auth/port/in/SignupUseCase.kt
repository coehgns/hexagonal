package com.example.hexagonal.application.auth.port.`in`

import com.example.hexagonal.adapter.`in`.auth.dto.request.SignupRequest

interface SignupUseCase {
    fun signup(signupRequest: SignupRequest)
}