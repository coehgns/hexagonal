package com.example.hexagonal.adapter.out.persistence.board

import com.example.hexagonal.domain.board.model.Board
import com.example.hexagonal.infrastructure.persistence.board.BoardJpaEntity
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface BoardMapper {
    fun toEntity(board: Board): BoardJpaEntity
    fun toModel(entity: BoardJpaEntity): Board
}