package com.example.boardinfrastructure.domain.board.domain

import com.example.boarddomain.domain.board.spi.BoardPort
import com.example.boarddomain.domain.board.model.Board
import com.example.boardinfrastructure.domain.board.domain.mapper.BoardMapper
import com.example.boardinfrastructure.domain.board.domain.repository.BoardJpaRepository
import org.springframework.stereotype.Component

@Component
class BoardPersistenceAdapter(
    private val boardJpaRepository: BoardJpaRepository,
    private val boardMapper: BoardMapper
) : BoardPort {
    override fun save(board: Board) {
        boardJpaRepository.save(
            boardMapper.toEntity(board)
        )
    }
}