package com.example.hexagonal.application.board.service

import com.example.hexagonal.adapter.`in`.board.dto.response.GetBoardResponse
import com.example.hexagonal.application.board.port.`in`.GetBoardUseCase
import com.example.hexagonal.application.board.port.out.BoardPort
import com.example.hexagonal.application.board.exception.BoardNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class GetBoardService(
    private val boardPort: BoardPort
) : GetBoardUseCase {
    @Transactional(readOnly = true)
    override fun getBoard(boardId: UUID): GetBoardResponse {
        val board = boardPort.findById(boardId) ?: throw BoardNotFoundException
        return GetBoardResponse(
            boardId = board.id!!,
            title = board.title,
            content = board.content
        )
    }
}