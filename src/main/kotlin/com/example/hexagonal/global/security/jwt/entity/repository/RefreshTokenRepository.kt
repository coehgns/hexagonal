package com.example.hexagonal.global.security.jwt.entity.repository

import com.example.hexagonal.global.security.jwt.entity.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String>