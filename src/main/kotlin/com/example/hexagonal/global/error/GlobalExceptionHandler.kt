package com.example.hexagonal.global.error

import com.example.hexagonal.global.error.exception.CustomException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler() {
    @ExceptionHandler(CustomException::class)
    fun handlerCustomException(e: CustomException): ResponseEntity<ErrorResponse> {
        val code = e.errorCode
        return ResponseEntity(
            ErrorResponse(code.status, message = code.message),
            HttpStatus.valueOf(code.status)
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun validatorExceptionHandler(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> {
        return ResponseEntity(
            ErrorResponse(400, e.bindingResult.allErrors[0].defaultMessage),
            HttpStatus.BAD_REQUEST
        )
    }
}