package com.example.hexagonal.application.user.exception

import com.example.hexagonal.global.error.exception.CustomException
import com.example.hexagonal.global.error.exception.ErrorCode

object UserAlreadyExistsException : CustomException(ErrorCode.USER_ALREADY_EXISTS)