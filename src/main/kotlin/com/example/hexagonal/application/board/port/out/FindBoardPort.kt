package com.example.hexagonal.application.board.port.out

import com.example.hexagonal.domain.board.model.Board
import java.util.UUID

interface FindBoardPort {
    fun findById(boardId: UUID): Board?
    fun findAll(): List<Board>
}