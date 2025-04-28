package com.example.hexagonal.domain.user.model

import java.util.UUID

data class User(
    val id: UUID?,
    val userName: String,
    val password: String
)
