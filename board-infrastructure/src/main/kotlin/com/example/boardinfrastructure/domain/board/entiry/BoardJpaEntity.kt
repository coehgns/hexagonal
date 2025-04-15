package com.example.boardinfrastructure.domain.board.entiry

import jakarta.persistence.*

@Entity
@Table(name = "tbl_board")
class BoardJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "title", nullable = false)
    var title: String,

    @Column(name = "content")
    val content: String? = null
)