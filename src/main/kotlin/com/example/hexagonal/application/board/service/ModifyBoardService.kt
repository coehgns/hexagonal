package com.example.hexagonal.application.board.service

import com.example.hexagonal.adapter.`in`.user.dto.request.ModifyBoardRequest
import com.example.hexagonal.application.board.port.`in`.ModifyBoardUseCase
import com.example.hexagonal.application.board.port.out.BoardPort
import com.example.hexagonal.domain.board.exception.BoardNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ModifyBoardService(
    private val boardPort: BoardPort
) : ModifyBoardUseCase {
    @Transactional
    override fun modifyBoard(boardId: UUID, request: ModifyBoardRequest) {
        val board = boardPort.findById(boardId) ?: throw BoardNotFoundException
        boardPort.saveBoard(board.modifyBoard(request))
    }
}