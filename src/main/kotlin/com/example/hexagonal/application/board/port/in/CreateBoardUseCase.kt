package com.example.hexagonal.application.board.port.`in`

import com.example.hexagonal.adapter.`in`.user.dto.request.CreateBoardRequest

interface CreateBoardUseCase {
    fun createBoard(request: CreateBoardRequest)
}