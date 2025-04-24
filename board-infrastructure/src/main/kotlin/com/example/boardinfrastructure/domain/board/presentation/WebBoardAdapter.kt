package com.example.boardinfrastructure.domain.board.presentation

import com.example.boarddomain.domain.board.usecase.CreateBoardUseCase
import com.example.boarddomain.domain.board.usecase.dto.request.CreateBoardRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/boards")
class WebBoardAdapter(
    private val createBoardUseCase: CreateBoardUseCase
) {
    @PostMapping
    fun createBoard(@RequestBody request: CreateBoardRequest) {
        createBoardUseCase.execute(request)
    }
}