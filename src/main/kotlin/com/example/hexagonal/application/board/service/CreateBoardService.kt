package com.example.hexagonal.application.board.service

import com.example.hexagonal.adapter.`in`.user.dto.request.CreateBoardRequest
import com.example.hexagonal.application.board.port.`in`.BoardUseCase
import com.example.hexagonal.application.board.port.out.FindBoardPort
import com.example.hexagonal.application.board.port.out.SaveBoardPort
import com.example.hexagonal.domain.board.model.Board
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreateBoardService(
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

    override fun findBoard(boardId: UUID): Board {
        val board = findBoard.findById(boardId)
            ?: throw IllegalArgumentException("board not found.")

        return board
    }

    override fun findAllBoard(): List<Board> {
        val boards = findBoard.findAll()

        return boards.map {
            Board(
                title = it.title,
                content = it.content
            )
        }
    }
}