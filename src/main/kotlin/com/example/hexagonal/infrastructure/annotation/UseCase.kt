package com.example.hexagonal.infrastructure.annotation

import org.springframework.transaction.annotation.Transactional

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@Transactional
annotation class UseCase()
