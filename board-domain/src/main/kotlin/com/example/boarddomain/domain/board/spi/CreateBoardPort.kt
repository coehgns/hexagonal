package com.example.boarddomain.domain.board.spi

import com.example.boarddomain.domain.board.model.Board

interface CreateBoardPort {
    fun save(board: Board)
}