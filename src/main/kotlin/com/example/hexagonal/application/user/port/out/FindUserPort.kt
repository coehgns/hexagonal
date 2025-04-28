package com.example.hexagonal.application.user.port.out

import com.example.hexagonal.domain.user.model.User
import java.util.UUID

interface FindUserPort {
    fun findById(userId: UUID): User?
    fun findByUserName(userName: String): User?
}