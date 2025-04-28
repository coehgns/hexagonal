package com.example.hexagonal.application.board.port.`in`

import com.example.hexagonal.adapter.`in`.user.dto.request.CreateBoardRequest
import com.example.hexagonal.adapter.`in`.user.dto.request.ModifyBoardRequest
import com.example.hexagonal.domain.board.model.Board
import java.util.UUID

interface BoardUseCase {
    fun createBoard(request: CreateBoardRequest)
    fun findBoard(boardId: UUID): Board
    fun findAllBoard(): List<Board>
    fun modifyBoard(request: ModifyBoardRequest)
}