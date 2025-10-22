package com.example.hexagonal.application.board.exception

import com.example.hexagonal.global.error.exception.CustomException
import com.example.hexagonal.global.error.exception.ErrorCode

object BoardNotFoundException : CustomException(ErrorCode.BOARD_NOT_FOUND)