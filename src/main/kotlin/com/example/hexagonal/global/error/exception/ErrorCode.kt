package com.example.hexagonal.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    BOARD_NOT_FOUND(404, "Board Not Found."),
    USER_NOT_FOUND(404, "User Not Found."),
    USER_ALREADY_EXISTS(409, "User Already Exist.")
}