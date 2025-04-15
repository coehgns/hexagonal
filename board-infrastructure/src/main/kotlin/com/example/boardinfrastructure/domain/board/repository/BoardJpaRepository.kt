package com.example.boardinfrastructure.domain.board.repository

import com.example.boardinfrastructure.domain.board.entiry.BoardJpaEntity
import org.springframework.data.repository.CrudRepository

interface BoardJpaRepository : CrudRepository<BoardJpaEntity, Long>