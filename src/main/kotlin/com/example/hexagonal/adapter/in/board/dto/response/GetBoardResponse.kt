package com.example.hexagonal.adapter.`in`.board.dto.response

import java.util.*

data class GetBoardResponse(
    val boardId: UUID,
    val title: String,
    val content: String?
)
