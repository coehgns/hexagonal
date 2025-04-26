package com.example.hexagonal.application.board.port.`in`

import com.example.hexagonal.adapter.`in`.user.dto.request.CreateBoardRequest

interface BoardUseCase {
    fun createBoard(request: CreateBoardRequest)
}