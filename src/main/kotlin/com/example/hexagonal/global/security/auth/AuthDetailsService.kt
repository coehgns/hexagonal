package com.example.hexagonal.global.security.auth

import com.example.hexagonal.application.user.port.out.FindUserPort
import com.example.hexagonal.domain.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class AuthDetailsService(
    private val findUserPort: FindUserPort
) : UserDetailsService {
    override fun loadUserByUsername(userId: String?): UserDetails {
        val user = findUserPort.findById(UUID.fromString(userId)) ?: throw UserNotFoundException
        return AuthDetails(user)
    }
}