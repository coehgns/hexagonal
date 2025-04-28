package com.example.hexagonal.application.board.port.`in`

import com.example.hexagonal.adapter.`in`.board.dto.response.GetBoardResponse

interface GetBoardListUseCase {
    fun getBoardList(): List<GetBoardResponse>
}