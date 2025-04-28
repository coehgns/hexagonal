package com.example.hexagonal.application.board.service

import com.example.hexagonal.adapter.`in`.user.dto.request.CreateBoardRequest
import com.example.hexagonal.adapter.`in`.user.dto.response.GetBoardResponse
import com.example.hexagonal.application.board.port.`in`.BoardUseCase
import com.example.hexagonal.application.board.port.out.FindBoardPort
import com.example.hexagonal.application.board.port.out.SaveBoardPort
import com.example.hexagonal.domain.board.model.Board
import org.springframework.stereotype.Service
import java.util.*

@Service
class BoardService(
    private val saveBoardPort: SaveBoardPort,
    private val findBoard: FindBoardPort
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

    override fun findBoard(boardId: UUID): GetBoardResponse {
        val board = findBoard.findById(boardId)
            ?: throw IllegalArgumentException("board not found.")

        return GetBoardResponse(
            boardId = board.id!!,
            title = board.title,
            content = board.content
        )
    }

    override fun findAllBoard(): List<GetBoardResponse> {
        val boards = findBoard.findAll()

        return boards.map {
            GetBoardResponse(
                boardId = it.id!!,
                title = it.title,
                content = it.content
            )
        }
    }
}