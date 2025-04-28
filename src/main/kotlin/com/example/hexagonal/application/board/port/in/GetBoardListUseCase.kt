package com.example.hexagonal.application.board.port.`in`

import com.example.hexagonal.adapter.`in`.user.dto.response.GetBoardResponse

interface GetBoardListUseCase {
    fun getBoardList(): List<GetBoardResponse>
}