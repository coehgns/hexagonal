package com.example.hexagonal.global.security.auth

import com.example.hexagonal.domain.user.model.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val user: User
) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return listOf<SimpleGrantedAuthority>(SimpleGrantedAuthority(user.userName))
    }

    override fun getPassword(): String? {
        return null
    }

    override fun getUsername(): String {
        return user.userName
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}