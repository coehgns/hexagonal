package com.example.hexagonal.application.board.service

import com.example.hexagonal.adapter.`in`.board.dto.request.CreateBoardRequest
import com.example.hexagonal.application.board.port.`in`.CreateBoardUseCase
import com.example.hexagonal.application.board.port.out.BoardPort
import com.example.hexagonal.domain.board.model.Board
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateBoardService(
    private val boardPort: BoardPort
) : CreateBoardUseCase{
    @Transactional
    override fun createBoard(request: CreateBoardRequest) {
        val board = request.run {
            Board(
                title = title,
                content = content
            )
        }
        boardPort.saveBoard(board)
    }
}