package com.example.hexagonal.adapter.out.entity.board

import com.example.hexagonal.global.entity.BaseUUIDEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import java.util.UUID

@Entity(name = "tbl_board")
class BoardJpaEntity(
    id: UUID?,
    title: String,
    content: String? = null
) : BaseUUIDEntity(id) {
    @Column(name = "title", nullable = false)
    var title: String = title
        protected set

    @Column(name = "content")
    var content: String? = content
        protected set
}