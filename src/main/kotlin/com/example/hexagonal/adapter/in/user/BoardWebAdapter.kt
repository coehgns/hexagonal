package com.example.hexagonal.adapter.`in`.user

import com.example.hexagonal.adapter.`in`.user.dto.request.CreateBoardRequest
import com.example.hexagonal.adapter.`in`.user.dto.request.ModifyBoardRequest
import com.example.hexagonal.adapter.`in`.user.dto.response.GetBoardResponse
import com.example.hexagonal.application.board.port.`in`.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/boards")
class BoardWebAdapter(
    private val createBoardUseCase: CreateBoardUseCase,
    private val getBoardUseCase: GetBoardUseCase,
    private val getBoardListUseCase: GetBoardListUseCase,
    private val modifyBoardUseCase: ModifyBoardUseCase,
    private val deleteBoardUseCase: DeleteBoardUseCase
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createBoard(@RequestBody request: CreateBoardRequest) = createBoardUseCase.createBoard(request)

    @GetMapping("/{boardId}")
    fun getBoard(@PathVariable("boardId") boardId: UUID): GetBoardResponse = getBoardUseCase.getBoard(boardId)

    @GetMapping
    fun getBoardList(): List<GetBoardResponse> = getBoardListUseCase.getBoardList()

    @PatchMapping("/{boardId}")
    fun modifyBoard(
        @PathVariable("boardId") boardId: UUID,
        @RequestBody request: ModifyBoardRequest
    ) = modifyBoardUseCase.modifyBoard(boardId, request)

    @DeleteMapping("/{boardId}")
    fun deleteBoard(@PathVariable("boardId") boardId: UUID) = deleteBoardUseCase.deleteBoard(boardId)
}