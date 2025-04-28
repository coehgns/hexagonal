package com.example.hexagonal.application.user.port.out

interface ExistUserPort {
    fun existsByUserName(userName: String): Boolean
}