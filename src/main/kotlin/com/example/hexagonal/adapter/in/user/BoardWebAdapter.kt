package com.example.hexagonal.adapter.`in`.user

import com.example.hexagonal.adapter.`in`.user.dto.request.CreateBoardRequest
import com.example.hexagonal.application.board.port.`in`.BoardUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/boards")
class BoardWebAdapter(
    private val boardUseCase: BoardUseCase
) {
    @PostMapping
    fun createBoard(@RequestBody request: CreateBoardRequest) = boardUseCase.createBoard(request)
}