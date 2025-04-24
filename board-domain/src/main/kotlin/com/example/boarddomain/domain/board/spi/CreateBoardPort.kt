package com.example.boarddomain.domain.board.spi

import com.example.boarddomain.domain.model.Board

interface CreateBoardPort {
    fun save(board: Board)
}