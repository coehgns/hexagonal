package com.example.hexagonal.global.error

data class ErrorResponse(
    val status: Int,
    val message: String?
)