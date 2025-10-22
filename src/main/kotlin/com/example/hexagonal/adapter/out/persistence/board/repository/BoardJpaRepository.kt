package com.example.hexagonal.adapter.out.persistence.board.repository

import com.example.hexagonal.adapter.out.entity.board.BoardJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BoardJpaRepository : JpaRepository<BoardJpaEntity, UUID>