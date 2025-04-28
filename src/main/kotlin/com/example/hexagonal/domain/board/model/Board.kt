package com.example.hexagonal.domain.board.model

import com.example.hexagonal.adapter.`in`.user.dto.request.ModifyBoardRequest
import java.util.*

data class Board(
    val id: UUID? = null,
    val title: String,
    val content: String? = null
) {
    fun modifyBoard(request: ModifyBoardRequest): Board {
        return copy(title = request.title, content = request.content)
    }
}