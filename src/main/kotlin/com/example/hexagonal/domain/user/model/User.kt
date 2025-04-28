package com.example.hexagonal.domain.user.model

import com.example.hexagonal.global.annotation.Aggregate
import java.util.UUID

@Aggregate
data class User(
    val id: UUID?,
    val userName: String,
    val password: String
)
