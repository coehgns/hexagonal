package com.example.hexagonal.adapter.out.persistence.user

import com.example.hexagonal.domain.user.model.User
import com.example.hexagonal.infrastructure.persistence.user.UserJpaEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface UserMapper {
    fun toEntity(user: User): UserJpaEntity
    fun toModel(entity: UserJpaEntity): User
}