package com.example.boarddomain.domain.board.usecase

import com.example.boarddomain.domain.board.spi.CreateBoardPort
import com.example.boarddomain.domain.board.usecase.dto.request.CreateBoardRequest
import com.example.boarddomain.domain.board.model.Board
import com.example.boarddomain.global.annotation.UseCase

@UseCase
class CreateBoardUseCase(
    private val createBoardPort: CreateBoardPort
) {
    fun execute(request: CreateBoardRequest) {
        request.run {
            createBoardPort.save(
                Board(
                    title = title,
                    content = content
                )
            )
        }
    }
}