package com.example.boardinfrastructure.domain.board.domain.entiry

import jakarta.persistence.*

@Entity
@Table(name = "tbl_board")
class BoardJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content")
    var content: String? = null
)