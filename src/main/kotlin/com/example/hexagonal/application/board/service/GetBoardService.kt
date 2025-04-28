package com.example.hexagonal.application.board.service

import com.example.hexagonal.adapter.`in`.user.dto.response.GetBoardResponse
import com.example.hexagonal.application.board.port.`in`.GetBoardUseCase
import com.example.hexagonal.application.board.port.out.BoardPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class GetBoardService(
    private val boardPort: BoardPort
) : GetBoardUseCase {
    @Transactional(readOnly = true)
    override fun getBoard(boardId: UUID): GetBoardResponse {
        val board = boardPort.findById(boardId)
            ?: throw IllegalArgumentException("board not found.")

        return GetBoardResponse(
            boardId = board.id!!,
            title = board.title,
            content = board.content
        )
    }
}