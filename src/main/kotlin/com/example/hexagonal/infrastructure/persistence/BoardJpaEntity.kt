package com.example.hexagonal.infrastructure.persistence

import com.example.hexagonal.domain.BaseUUIDEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import java.util.*

@Entity(name = "tbl_board")
class BoardJpaEntity(
    id: UUID,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content")
    var content: String? = null
) : BaseUUIDEntity(id)