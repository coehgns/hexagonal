package com.example.hexagonal.global.security.jwt

import com.example.hexagonal.global.security.auth.AuthDetailsService
import com.example.hexagonal.global.security.jwt.dto.TokenResponse
import com.example.hexagonal.global.security.jwt.entity.RefreshToken
import com.example.hexagonal.global.security.jwt.entity.repository.RefreshTokenRepository
import com.example.hexagonal.global.env.JwtProperties
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.Date

@Component
class JwtProvider(
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository
) {
    companion object {
        private const val ACCESS_TOKEN = "access_token"
        private const val REFRESH_TOKEN = "refresh_token"
    }

    fun generateTokens(userName: String): TokenResponse {
        val accessToken = generateAccessToken(userName, ACCESS_TOKEN, jwtProperties.accessExp)
        val refreshToken = generateRefreshToken(REFRESH_TOKEN, jwtProperties.refreshExp)
        refreshTokenRepository.save(
            RefreshToken(
                id = userName,
                token = refreshToken,
                ttl = jwtProperties.refreshExp
            )
        )
        return TokenResponse(accessToken, refreshToken)
    }

    private fun generateAccessToken(userName: String, type: String, exp: Long): String {
        return Jwts.builder()
            .setSubject(userName)
            .claim("typ", type)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .signWith(Keys.hmacShaKeyFor(jwtProperties.secretKey.toByteArray()), SignatureAlgorithm.HS256)
            .compact()
    }

    private fun generateRefreshToken(type: String, exp: Long): String {
        return Jwts.builder()
            .claim("typ", type)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .signWith(Keys.hmacShaKeyFor(jwtProperties.secretKey.toByteArray()), SignatureAlgorithm.HS256)
            .compact()
    }
}