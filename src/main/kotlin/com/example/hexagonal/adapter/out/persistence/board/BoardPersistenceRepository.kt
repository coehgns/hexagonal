package com.example.hexagonal.adapter.out.persistence.board

import com.example.hexagonal.adapter.out.persistence.board.repository.BoardJpaRepository
import com.example.hexagonal.application.board.port.out.SaveBoardPort
import com.example.hexagonal.domain.board.model.Board
import org.springframework.stereotype.Component

@Component
class BoardPersistenceRepository(
    private val boardJpaRepository: BoardJpaRepository,
    private val boardMapper: BoardMapper
) : SaveBoardPort {
    override fun saveBoard(board: Board) {
        boardJpaRepository.save(boardMapper.toEntity(board))
    }
}