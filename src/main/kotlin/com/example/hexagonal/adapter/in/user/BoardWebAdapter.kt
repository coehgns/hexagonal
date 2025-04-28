package com.example.hexagonal.adapter.`in`.user

import com.example.hexagonal.adapter.`in`.user.dto.request.CreateBoardRequest
import com.example.hexagonal.adapter.`in`.user.dto.request.ModifyBoardRequest
import com.example.hexagonal.adapter.`in`.user.dto.response.GetBoardResponse
import com.example.hexagonal.application.board.port.`in`.BoardUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/boards")
class BoardWebAdapter(
    private val boardUseCase: BoardUseCase
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createBoard(@RequestBody request: CreateBoardRequest) = boardUseCase.createBoard(request)

    @GetMapping("/{boardId}")
    fun findBoard(@PathVariable("boardId") boardId: UUID): GetBoardResponse = boardUseCase.findBoard(boardId)

    @GetMapping
    fun findAllBoard(): List<GetBoardResponse> = boardUseCase.findAllBoard()

    @PatchMapping("/{boardId}")
    fun modifyBoard(
        @PathVariable("boardId") boardId: UUID,
        @RequestBody request: ModifyBoardRequest
    ) = boardUseCase.modifyBoard(boardId, request)

    @DeleteMapping("/{boardId}")
    fun deleteBoard(@PathVariable("boardId") boardId: UUID) = boardUseCase.deleteBoard(boardId)
}