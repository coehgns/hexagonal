package com.example.hexagonal.application.board.service

import com.example.hexagonal.adapter.`in`.user.dto.request.CreateBoardRequest
import com.example.hexagonal.application.board.port.`in`.BoardUseCase
import com.example.hexagonal.application.board.port.out.SaveBoardPort
import com.example.hexagonal.domain.board.model.Board
import org.springframework.stereotype.Service

@Service
class CreateBoardService(
    private val saveBoardPort: SaveBoardPort
): BoardUseCase {
    override fun createBoard(request: CreateBoardRequest) {
        val board = request.run {
            Board(
                title = title,
                content = content
            )
        }
        saveBoardPort.saveBoard(board)
    }
}