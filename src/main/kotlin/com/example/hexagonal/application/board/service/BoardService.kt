package com.example.hexagonal.application.board.service

import com.example.hexagonal.adapter.`in`.user.dto.request.CreateBoardRequest
import com.example.hexagonal.adapter.`in`.user.dto.request.ModifyBoardRequest
import com.example.hexagonal.adapter.`in`.user.dto.response.GetBoardResponse
import com.example.hexagonal.application.board.port.`in`.BoardUseCase
import com.example.hexagonal.application.board.port.out.DeleteBoardPort
import com.example.hexagonal.application.board.port.out.FindBoardPort
import com.example.hexagonal.application.board.port.out.SaveBoardPort
import com.example.hexagonal.domain.board.model.Board
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class BoardService(
    private val saveBoardPort: SaveBoardPort,
    private val findBoardPort: FindBoardPort,
    private val deleteBoardPort: DeleteBoardPort
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
        val board = findBoardPort.findById(boardId)
            ?: throw IllegalArgumentException("board not found.")

        return GetBoardResponse(
            boardId = board.id!!,
            title = board.title,
            content = board.content
        )
    }

    override fun findAllBoard(): List<GetBoardResponse> {
        val boards = findBoardPort.findAll()

        return boards.map {
            GetBoardResponse(
                boardId = it.id!!,
                title = it.title,
                content = it.content
            )
        }
    }

    @Transactional
    override fun modifyBoard(boardId: UUID, request: ModifyBoardRequest) {
        val board = findBoardPort.findById(boardId)
            ?: throw IllegalArgumentException("board not found.")

        saveBoardPort.saveBoard(board.modifyBoard(request))
    }

    override fun deleteBoard(boardId: UUID) {
        val board = findBoardPort.findById(boardId)
            ?: throw IllegalArgumentException("board not found.")

        deleteBoardPort.deleteBoard(board)
    }
}