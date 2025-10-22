package com.example.hexagonal.global.security.auth

import com.example.hexagonal.application.user.port.out.UserPort
import com.example.hexagonal.application.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class AuthDetailsService(
    private val userPort: UserPort
) : UserDetailsService {
    override fun loadUserByUsername(userId: String?): UserDetails {
        val user = userPort.findById(UUID.fromString(userId)) ?: throw UserNotFoundException
        return AuthDetails(user)
    }
}