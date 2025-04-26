package com.example.hexagonal.domain.board.model

import java.util.*

data class Board(
    val id: UUID? = null,
    val title: String,
    val content: String? = null
)