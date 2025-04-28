package com.example.hexagonal.domain.board.model

import com.example.hexagonal.adapter.`in`.board.dto.request.ModifyBoardRequest
import com.example.hexagonal.global.annotation.Aggregate
import java.util.*

@Aggregate
data class Board(
    val id: UUID? = null,
    val title: String,
    val content: String? = null
) {
    fun modifyBoard(request: ModifyBoardRequest): Board {
        return copy(title = request.title, content = request.content)
    }
}