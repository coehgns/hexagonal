package com.example.hexagonal.domain.user.exception

import com.example.hexagonal.global.error.exception.CustomException
import com.example.hexagonal.global.error.exception.ErrorCode

object PasswordMismatchException : CustomException(ErrorCode.PASSWORD_MISMATCH)