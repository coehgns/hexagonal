package com.example.hexagonal.application.board.port.out

import com.example.hexagonal.domain.board.model.Board

interface DeleteBoardPort {
    fun deleteBoard(board: Board)
}