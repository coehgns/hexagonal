package com.example.hexagonal.adapter.`in`.auth

import com.example.hexagonal.adapter.`in`.auth.dto.request.SignupRequest
import com.example.hexagonal.application.auth.port.`in`.SignupUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class UserWebAdapter(
    private val signupUseCase: SignupUseCase
) {
    @PostMapping("/signup")
    fun signup(@RequestBody request: SignupRequest) = signupUseCase.signup(request)
}