package com.example.boarddomain.domain.board.usecase.dto.request

data class CreateBoardRequest(
    val title: String,
    val content: String? = null
)
