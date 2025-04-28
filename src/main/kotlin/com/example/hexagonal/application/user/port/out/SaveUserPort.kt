package com.example.hexagonal.application.user.port.out

import com.example.hexagonal.domain.user.model.User

interface SaveUserPort {
    fun saveUser(user: User)
}