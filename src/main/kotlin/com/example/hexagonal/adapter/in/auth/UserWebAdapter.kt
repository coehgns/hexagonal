package com.example.hexagonal.adapter.`in`.auth

import com.example.hexagonal.adapter.`in`.auth.dto.request.LoginRequest
import com.example.hexagonal.adapter.`in`.auth.dto.request.SignupRequest
import com.example.hexagonal.application.auth.port.`in`.LoginUseCase
import com.example.hexagonal.application.auth.port.`in`.SignupUseCase
import com.example.hexagonal.global.security.jwt.dto.TokenResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class UserWebAdapter(
    private val signupUseCase: SignupUseCase,
    private val loginUseCase: LoginUseCase
) {
    @PostMapping("/signup")
    fun signup(@RequestBody request: SignupRequest) = signupUseCase.signup(request)

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): TokenResponse =
        loginUseCase.login(request)
}