package com.example.hexagonal.application.auth.port.service

import com.example.hexagonal.adapter.`in`.auth.dto.request.LoginRequest
import com.example.hexagonal.application.auth.port.`in`.LoginUseCase
import com.example.hexagonal.application.user.port.out.UserPort
import com.example.hexagonal.domain.user.exception.PasswordMismatchException
import com.example.hexagonal.domain.user.exception.UserNotFoundException
import com.example.hexagonal.global.security.jwt.JwtProvider
import com.example.hexagonal.global.security.jwt.dto.TokenResponse
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val jwtProvider: JwtProvider,
    private val userPort: UserPort,
    private val passwordEncoder: PasswordEncoder
) : LoginUseCase {
    override fun login(request: LoginRequest): TokenResponse {
        val user = userPort.findByUserName(request.userName) ?: throw UserNotFoundException
        val tokens = jwtProvider.generateTokens(request.userName)

        if (passwordEncoder.matches(user.password, request.password)) {
            throw PasswordMismatchException
        }

        return TokenResponse(
            accessToken = tokens.accessToken,
            refreshToken = tokens.refreshToken
        )
    }
}