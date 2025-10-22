package com.example.hexagonal.adapter.out.persistence.user.repository

import com.example.hexagonal.adapter.out.entity.user.UserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserJpaRepository : JpaRepository<UserJpaEntity, UUID> {
    fun existsByUserName(userName: String): Boolean
    fun findByUserName(userName: String): UserJpaEntity?
}