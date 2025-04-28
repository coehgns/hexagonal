package com.example.hexagonal.application.board.port.`in`

import java.util.*

interface DeleteBoardUseCase {
    fun deleteBoard(boardId: UUID)
}