package com.example.hexagonal.domain.user.exception

import com.example.hexagonal.global.error.exception.CustomException
import com.example.hexagonal.global.error.exception.ErrorCode

object UserNotFoundException : CustomException(ErrorCode.USER_NOT_FOUND