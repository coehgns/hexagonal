package com.example.hexagonal.application.auth.port.service

import com.example.hexagonal.adapter.`in`.auth.dto.request.SignupRequest
import com.example.hexagonal.application.auth.port.`in`.SignupUseCase
import com.example.hexagonal.application.user.port.out.ExistUserPort
import com.example.hexagonal.application.user.port.out.UserPort
import com.example.hexagonal.domain.user.exception.UserAlreadyExistsException
import com.example.hexagonal.domain.user.model.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignupService(
    private val userPort: UserPort,
    private val existUserPort: ExistUserPort,
    private val passwordEncoder: PasswordEncoder
) : SignupUseCase {
    override fun signup(signupRequest: SignupRequest) {
        val user = signupRequest.run {
            User(
                id = null,
                userName = userName,
                password = passwordEncoder.encode(signupRequest.password)
            )
        }

        if (existUserPort.existsByUserName(user.userName)) {
            throw UserAlreadyExistsException
        }

        userPort.saveUser(user)
    }
}