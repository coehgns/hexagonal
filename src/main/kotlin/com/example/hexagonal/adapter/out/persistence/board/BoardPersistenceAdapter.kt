package com.example.hexagonal.adapter.out.persistence.board

import com.example.hexagonal.adapter.out.persistence.board.repository.BoardJpaRepository
import com.example.hexagonal.application.board.port.out.DeleteBoardPort
import com.example.hexagonal.application.board.port.out.FindBoardPort
import com.example.hexagonal.application.board.port.out.SaveBoardPort
import com.example.hexagonal.domain.board.model.Board
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.util.*

@Component
class BoardPersistenceAdapter(
    private val boardJpaRepository: BoardJpaRepository,
    private val boardMapper: BoardMapper,
) : SaveBoardPort, FindBoardPort, DeleteBoardPort {
    override fun saveBoard(board: Board) {
        boardJpaRepository.save(boardMapper.toEntity(board))
    }

    override fun findById(boardId: UUID): Board? {
        return boardJpaRepository.findByIdOrNull(boardId)?.let { boardMapper.toModel(it) }
    }

    override fun findAll(): List<Board> = boardJpaRepository.findAll().map { boardMapper.toModel(it) }

    override fun deleteBoard(board: Board) {
        boardJpaRepository.delete(boardMapper.toEntity(board))
    }
}