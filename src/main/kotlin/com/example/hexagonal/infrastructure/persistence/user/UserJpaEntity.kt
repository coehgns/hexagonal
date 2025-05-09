package com.example.hexagonal.infrastructure.persistence.user

import com.example.hexagonal.domain.BaseUUIDEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import java.util.*

@Entity(name = "tbl_user")
class UserJpaEntity(
    id: UUID?,
    userName: String,
    password: String
) : BaseUUIDEntity(id) {
    @Column(name = "name", nullable = false)
    var userName: String = userName
        protected set

    @Column(name = "password", nullable = false)
    var password: String = password
        protected set
}