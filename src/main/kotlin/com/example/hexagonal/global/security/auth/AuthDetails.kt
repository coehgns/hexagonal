package com.example.hexagonal.global.security.auth

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val userName: String
) : UserDetails {
    override fun getAuthorities(): Collection<GrantedAuthority> {
        return listOf<SimpleGrantedAuthority>(SimpleGrantedAuthority(userName))
    }

    override fun getPassword(): String? {
        return null
    }

    override fun getUsername(): String {
        return userName
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