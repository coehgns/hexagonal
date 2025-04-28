package com.example.hexagonal.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    BOARD_NOT_FOUND(404, "Board Not Found.")
}