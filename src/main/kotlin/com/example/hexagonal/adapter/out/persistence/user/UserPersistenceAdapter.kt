package com.example.hexagonal.adapter.out.persistence.user

import com.example.hexagonal.adapter.out.persistence.user.repository.UserJpaRepository
import com.example.hexagonal.application.user.port.out.UserPort
import com.example.hexagonal.domain.user.model.User
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserPersistenceAdapter(
    private val userJpaRepository: UserJpaRepository,
    private val userMapper: UserMapper
) : UserPort {
    override fun findById(userId: UUID): User? {
        return userJpaRepository.findByIdOrNull(userId)?.let { userMapper.toModel(it) }
    }
}