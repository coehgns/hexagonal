package com.example.boardinfrastructure.domain.board.domain.mapper

import com.example.boarddomain.domain.board.model.Board
import com.example.boardinfrastructure.domain.board.domain.entiry.BoardJpaEntity
import com.example.boardinfrastructure.global.mapper.GenericMapper
import org.mapstruct.Mapper

@Mapper
abstract class BoardMapper : GenericMapper<BoardJpaEntity, Board> {
    abstract override fun toEntity(model: Board): BoardJpaEntity
}