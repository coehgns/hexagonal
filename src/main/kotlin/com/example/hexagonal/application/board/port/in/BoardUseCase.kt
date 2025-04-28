package com.example.hexagonal.application.board.port.`in`

import com.example.hexagonal.adapter.`in`.user.dto.request.CreateBoardRequest
import com.example.hexagonal.adapter.`in`.user.dto.request.ModifyBoardRequest
import com.example.hexagonal.adapter.`in`.user.dto.response.GetBoardResponse
import java.util.UUID

interface BoardUseCase {
    fun createBoard(request: CreateBoardRequest)
    fun findBoard(boardId: UUID): GetBoardResponse
    fun findAllBoard(): List<GetBoardResponse>
    fun modifyBoard(request: ModifyBoardRequest)
}