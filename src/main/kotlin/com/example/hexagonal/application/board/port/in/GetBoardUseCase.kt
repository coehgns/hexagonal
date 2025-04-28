package com.example.hexagonal.application.board.port.`in`

import com.example.hexagonal.adapter.`in`.user.dto.response.GetBoardResponse
import java.util.*

interface GetBoardUseCase {
    fun getBoard(boardId: UUID): GetBoardResponse
}