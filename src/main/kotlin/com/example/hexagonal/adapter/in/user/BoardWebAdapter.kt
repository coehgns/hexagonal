package com.example.hexagonal.adapter.`in`.user

import com.example.hexagonal.adapter.`in`.user.dto.request.CreateBoardRequest
import com.example.hexagonal.adapter.`in`.user.dto.response.GetBoardResponse
import com.example.hexagonal.application.board.port.`in`.BoardUseCase
import com.example.hexagonal.domain.board.model.Board
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/boards")
class BoardWebAdapter(
    private val boardUseCase: BoardUseCase
) {
    @PostMapping
    fun createBoard(@RequestBody request: CreateBoardRequest) = boardUseCase.createBoard(request)

    @GetMapping("/{boardId}")
    fun findBoard(@PathVariable("boardId") boardId: UUID): GetBoardResponse = boardUseCase.findBoard(boardId)

    @GetMapping
    fun findAllBoard(): List<GetBoardResponse> = boardUseCase.findAllBoard()
}