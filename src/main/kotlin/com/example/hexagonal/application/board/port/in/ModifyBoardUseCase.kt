package com.example.hexagonal.application.board.port.`in`

import com.example.hexagonal.adapter.`in`.board.dto.request.ModifyBoardRequest
import java.util.*

interface ModifyBoardUseCase {
    fun modifyBoard(boardId: UUID, request: ModifyBoardRequest)
}