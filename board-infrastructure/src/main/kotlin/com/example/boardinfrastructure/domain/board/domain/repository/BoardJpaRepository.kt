package com.example.boardinfrastructure.domain.board.domain.repository

import com.example.boardinfrastructure.domain.board.domain.entiry.BoardJpaEntity
import org.springframework.data.repository.CrudRepository

interface BoardJpaRepository : CrudRepository<BoardJpaEntity, Long>