package com.example.hexagonal.global.config.security

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsUtils

@EnableWebSecurity
class SecurityConfig() {
    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .formLogin { it.disable() }
            .sessionManagement { session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }

        http.authorizeHttpRequests { authorize ->
            authorize
                .requestMatchers(CorsUtils::isCorsRequest).permitAll()
                .requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
        }

        return http.build()
    }
}