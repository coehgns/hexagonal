package com.example.hexagonal.application.board.service

import com.example.hexagonal.adapter.`in`.board.dto.response.GetBoardResponse
import com.example.hexagonal.application.board.port.`in`.GetBoardListUseCase
import com.example.hexagonal.application.board.port.out.BoardPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetBoardListService(
    private val boardPort: BoardPort
) : GetBoardListUseCase {
    @Transactional(readOnly = true)
    override fun getBoardList(): List<GetBoardResponse> {
        val boards = boardPort.findAll()
        return boards.map {
            GetBoardResponse(
                boardId = it.id!!,
                title = it.title,
                content = it.content
            )
        }
    }
}