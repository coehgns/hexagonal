package com.example.hexagonal.global.error.exception

abstract class CustomException (
    val errorCode: ErrorCode
) : RuntimeException()